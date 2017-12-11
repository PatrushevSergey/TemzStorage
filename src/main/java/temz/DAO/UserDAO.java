package temz.DAO;

import temz.model.UserEntity;

import java.util.List;

/**
 * Created by Сергей on 05.09.2017.
 */
public interface UserDAO {
    void create(UserEntity user);
    void delete(int id);
    UserEntity findByAuth(String login, String password);
    UserEntity findByLogin(String login);
    UserEntity findById(int id);
    List<UserEntity> findAll();

}
