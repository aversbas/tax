package dao.idao;

import dao.PersistException;
import entyties.User;

import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public interface IUserDao {
    User getUserById(long id) throws PersistException;
    List<User> getAllUsers();
    long save(User user);
    void update(User user);
    void delete(User user);
    boolean getUserByUserNameAndPassword(String userName, String password);
    long getIdByUserName(String name);
}
