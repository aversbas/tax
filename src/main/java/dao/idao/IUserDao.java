package dao.idao;

import dao.util.PersistException;
import entyties.User;

import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public interface IUserDao {
    /**
     * @param id
     * @return
     * @throws PersistException
     */
    User getUserById(long id) throws PersistException;

    /**
     * @return
     */
    List<User> getAllUsers();

    /**
     * @param user
     */
    void save(User user);

    /**
     * @param user
     */
    void update(User user);

    /**
     * @param user
     */
    void delete(User user);

    /**
     * @param userName
     * @param password
     * @return
     */
    boolean getUserByUserNameAndPassword(String userName, String password);

    /**
     * @param name
     * @return
     */
    long getIdByUserName(String name);
}
