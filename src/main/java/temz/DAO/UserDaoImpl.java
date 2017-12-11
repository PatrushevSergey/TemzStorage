package temz.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import temz.model.UserEntity;

import java.util.List;

/**
 * Created by Сергей on 05.09.2017.
 */
@Repository
public class UserDaoImpl implements UserDAO {

    private final HibernateTemplate template;

    @Autowired
    public UserDaoImpl(HibernateTemplate template) {
        this.template = template;
    }

    public void create(UserEntity user) {
        this.template.save(user);
    }

    public void delete(int id) {

    }

    public UserEntity findById(int id) {
        return (UserEntity)this.template.find("from UserEntity where id=?", id).get(0);
    }

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>)template.find("from UserEntity ");
    }

    public UserEntity findByAuth(String login, String password) {
        List<UserEntity> users = (List<UserEntity>)this.template.find("from UserEntity ");
        for(UserEntity x:users) {
            if(x.getLogin().equals(login) && x.getPassword().equals(password)) return x;
        }
        return null;
    }

    @Override
    public UserEntity findByLogin(String login) {
        return (UserEntity)this.template.find("from UserEntity where login=?", login).get(0);
    }
}
