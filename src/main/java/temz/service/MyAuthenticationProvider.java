package temz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import temz.model.UserEntity;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 10.09.2017.
 */
@Service("provider")
public class MyAuthenticationProvider implements AuthenticationProvider{

    private final UserService service;

    @Autowired
    public MyAuthenticationProvider(UserService service) {
        this.service = service;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserEntity user = service.findByAuth(login, password);
        if(user!=null) {
            List<GrantedAuthority> authorityList = new ArrayList<>();
            String role = user.getRole();
            System.out.println(role);
            authorityList.add(new SimpleGrantedAuthority(role));
            return new UsernamePasswordAuthenticationToken(login, password, authorityList);
        }
        else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}
