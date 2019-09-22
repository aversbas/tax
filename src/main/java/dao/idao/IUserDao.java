package dao.idao;

import entyties.User;

import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public interface IUserDao {
    User getUserById(long id);
    List<User> getAllUsers();
    void save(User user);
    void update(User user);
    void delete(User user);
    boolean getUserByUserNameAndPassword(String userName, String password);
    int getIdByUserName(String name);
}
