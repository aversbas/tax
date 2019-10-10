package dao.daoImpl;

import dao.util.ConnectionFactory;
import dao.idao.IUserDao;
import entyties.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {

    Logger log = Logger.getLogger(UserDaoImpl.class);

    public long getIdByUserName(String name) {
        int id = 0;
        String sql = "SELECT id FROM users WHERE user_name = ?";
        ResultSet rs = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
                log.info("get userId by username success");
            }
            return id;
        } catch (SQLException e) {
            log.error("cannot get userId by username: " + e.getMessage());
        }
        return id;
    }


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM users";
        ResultSet rs = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getLong(1));
                user.setUserName(rs.getString(3));
                user.setUserMail(rs.getString(2));
                user.setUserPassword(rs.getString(4));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            log.error(e);
        }

        return null;
    }

    public void save(User user) {
        String userName = user.getUserName();
        String email = user.getUserMail();
        String password = user.getUserPassword();
        log.info("save username: " + userName);
        log.info("save email: " + email);
        log.info("save password: " + password);
        String sql = "INSERT INTO users (user_email, user_name, user_password) VALUES (?,?,?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, email);
            stmt.setString(2, userName);
            stmt.setString(3, password);
            stmt.executeUpdate();
            log.info("user saved");
        }catch (SQLException e){
            log.error(e);
        }
    }

    public void update(User user) {

    }

    public void delete(User user) {

    }

    public boolean getUserByUserNameAndPassword(String userName, String password) {
        log.info("UserDaoImpl:username:" + userName);
        log.info("UserDaoImpl: password:" + password);
        String sql = "SELECT * FROM users WHERE user_name=? AND user_password=?";
        ResultSet rs = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            log.info("before rs block");
            stmt.setString(1, userName);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                log.info("rs block");
                return true;
            }

        } catch (SQLException e) {
            log.error(e);
        }
        return false;
    }

    public User getUserById(long id) {
        String sql = "SELECT id, user_name, user_email FROM users WHERE id = ?";
        ResultSet rs = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            User user = new User();
            if (rs.next()) {


                user.setUserId(rs.getLong("id"));
                user.setUserName(rs.getString("userName"));
                user.setUserMail(rs.getString("userEmail"));
            }
            return user;
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }
}
