package dao.daoImpl;

import dao.ConnectionFactory;
import dao.PersistException;
import dao.idao.IUserActionDao;
import dao.idao.IUserDao;
import entyties.Action;
import entyties.User;
import entyties.UserAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alexm on 20.09.2019.
 */
public class UserActionDaoImpl implements IUserActionDao {

    IUserDao userDao = new UserDaoImpl();

    public void createnewUserAction(Action action) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("INSERT INTO user_action (user_id, action_id) VALUES (?, ?)");
            stmt.setLong(1, action.getId());
            stmt.setLong(2, action.getId());
            stmt.executeUpdate();


        } catch (SQLException e) {
            e.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
        }

    }

    public UserAction getUserActionByAction(Action action) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM user_action WHERE action_id=?");
//            stmt.setLong(1, action.getId());
            stmt.getResultSet();
            rs = stmt.executeQuery();
            User user;
            UserAction userAction = new UserAction();
            if (rs.next()) {
                userAction.setId(rs.getLong(1));
                user = userDao.getUserById(rs.getInt(3));
                userAction.setAction(action);
                userAction.setUser(user);
                 action.setDiscount(rs.getDouble(2));
            }
            return userAction;
        } catch (SQLException e) {
            e.getMessage();
        } catch (PersistException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
        }

        return null;
    }
}