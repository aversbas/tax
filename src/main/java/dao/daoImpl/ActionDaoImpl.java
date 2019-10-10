package dao.daoImpl;

import dao.util.ConnectionFactory;
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
        String sql = "INSERT INTO action (discount) VALUE (?)";
        ResultSet rs = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

                stmt.setDouble(1, 0);
                stmt.executeUpdate();

            log.info("action added successfully");

        } catch (SQLException e) {
            log.error("cannot add action: " + e.getMessage());
        }
    }

    @Override
    public void addSumToAction(User user, Action action, double sum) {
        double lastSum = getUserAction(user).getDiscount();
        String sql = "UPDATE action set discount=? where id=?";
        ResultSet rs = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, user.getId());
            stmt.setDouble(2, lastSum+sum);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void takeSumFromAction(User user, Action action, double sum) {

    }

    @Override
    public Action getUserAction(User user) {
        String sql = "SELECT action.discount,action.userId " +
                     "FROM action JOIN user_action ua on action.id = ua.action_id " +
                     "JOIN users on ua.user_id = users.id WHERE ua.user_id = ?";
        ResultSet rs = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, user.getId());
            rs = stmt.executeQuery();
            Action action = new Action();
            if (rs.next()) {
                action.setDiscount(rs.getDouble(1));
                action.setId(rs.getLong(2));
            }
            return action;
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }
}
