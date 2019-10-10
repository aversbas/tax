package dao.daoImpl;

import dao.util.ConnectionFactory;
import dao.idao.IUserActionDao;
import dao.idao.IUserDao;
import entyties.Action;
import entyties.User;
import entyties.UserAction;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alexm on 20.09.2019.
 */
public class UserActionDaoImpl implements IUserActionDao {

    Logger log = Logger.getLogger(UserActionDaoImpl.class);

    IUserDao userDao = new UserDaoImpl();

    public void createnewUserAction(Action action) {

        String sql = "INSERT INTO user_action (user_id, action_id) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, action.getId());
            stmt.setLong(2, action.getId());
            stmt.executeUpdate();


        } catch (SQLException e) {
            log.error(e);
        }
    }

    public UserAction getUserActionByAction(Action action) {

        String sql = "SELECT * FROM user_action WHERE action_id=?";
        ResultSet rs = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, action.getId());
            rs = stmt.executeQuery();

            User user;
            UserAction userAction = new UserAction();
            if (rs.next()) {
                userAction.setId(rs.getLong(1));
                user = userDao.getUserById(rs.getInt(4));
                userAction.setAction(action);
                userAction.setUser(user);
                action.setDiscount(rs.getDouble(1));
            }
            return userAction;
        } catch (SQLException e) {
            log.error(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}