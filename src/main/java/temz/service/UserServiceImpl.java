package temz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import temz.DAO.UserDAO;
import temz.model.UserEntity;

import java.util.List;

/**
 * Created by Сергей on 05.09.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Transactional
    public void create(UserEntity user) {
        this.userDAO.create(user);
    }

    @Transactional
    public void delete(int id) {
        this.userDAO.delete(id);
    }

    @Transactional
    public UserEntity findByAuth(String login, String password) {
        return this.userDAO.findByAuth(login, password);
    }

    @Transactional
    public UserEntity findByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    @Transactional
    public UserEntity findById(int id) {
        return this.userDAO.findById(id);
    }

   @Transactional
    public List<UserEntity> findAll() {
        return this.userDAO.findAll();
    }
}
