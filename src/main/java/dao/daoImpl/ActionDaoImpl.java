package dao.daoImpl;

import dao.ConnectionFactory;
import dao.idao.IActionDao;
import entyties.Action;
import entyties.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alexm on 20.09.2019.
 */
public class ActionDaoImpl implements IActionDao {

    Logger log = Logger.getLogger(ActionDaoImpl.class);

    @Override
    public void addNewAction(Action action) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("INSERT INTO action (discount) value ?");
            stmt.setDouble(1, 0);
            stmt.executeUpdate();
            log.info("action added successfully");

        } catch (SQLException e) {
            log.error("cannot add action: " + e.getMessage());
            e.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    log.error("stmt error: " + e.getMessage());
                    e.getMessage();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    log.error("connection error: " + e.getMessage());
                    log.info("");
                    e.getMessage();
                }
            }
        }
    }

    @Override
    public void addSumToAction(User user, Action action, double sum) {
        double lastSum = getUserAction(user).getDiscount();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("UPDATE action set discount=? where id=?");
            stmt.setDouble(1, lastSum+sum);
            stmt.setLong(2, user.getId());
            stmt.executeUpdate();



        } catch (SQLException e) {
            e.getMessage();
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
    }

    @Override
    public void takeSumFromAction(User user, Action action, double sum) {

    }

    @Override
    public Action getUserAction(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT discount,userId  " +
                    "from action join user_action ua on action.id = ua.action_id " +
                    "join users on ua.user_id = users.id where ua.user_id = ?;");
            stmt.setLong(1, user.getId());
            rs = stmt.executeQuery();
            Action action = new Action();
            if (rs.next()) {
                action.setId(rs.getLong(2));
                action.setDiscount(rs.getDouble(1));
            }
            return action;
        } catch (SQLException e) {
            e.getMessage();
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
