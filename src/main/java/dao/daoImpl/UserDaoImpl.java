package dao.daoImpl;

import dao.ConnectionFactory;
import dao.idao.IUserDao;
import entyties.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public class UserDaoImpl implements IUserDao {

    Logger log = Logger.getLogger(UserDaoImpl.class);

    @Override
    public User getUserById(long id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT id, user_name, user_email FROM users WHERE id = ?");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            // here was user = null;
            User user = new User();
            if (rs.next()) {


                user.setUserId(rs.getLong("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserMail(rs.getString("userMail"));
            }
            return user;
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

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<User>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM users");
            rs = stmt.executeQuery();
            //User user = null;
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getLong(1));
                user.setUserName(rs.getString(2));
                user.setUserMail(rs.getString(3));
                user.setUserPassword(rs.getString(4));
                users.add(user);

                // users.add(processRow(rs));

            }
            return users;
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

    @Override
    public void save(User user) {

        String userName = user.getUserName();
        String email = user.getUserMail();
        String password = user.getUserPassword();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("INSERT INTO users (user_name, user_email, user_password) VALUES (?,?,?)");
            stmt.setString(1, userName);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.executeUpdate();
            System.out.println("user saved");
        } catch (SQLException e) {

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

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public boolean getUserByUserNameAndPassword(String userName, String password) {

        log.info("UserDaoImpl:username:" + userName);
        log.info("UserDaoImpl: password:" + password);

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            log.info("before rs block");
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM users WHERE user_name=? AND user_password=?");
            stmt.setString(1, userName);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("rs block");


                return true;
            }

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
        return false;
    }

    @Override
    public int getIdByUserName(String name) {

        int id = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT id FROM users WHERE user_name = ?");
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("userId");
                log.info("get userId by username success");
            }
            return id;
        } catch (SQLException e) {
            log.error("cannot get userId by username: " + e.getMessage());
            e.getMessage();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    log.error("error geting user: " + e.getMessage());
                    e.getMessage();
                }
            } else if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    log.error("error geting user: " + e.getMessage());
                    e.getMessage();
                }
            } else if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    log.error("connection error: " + e.getMessage());
                    e.getMessage();
                }
            }
        }
        return id;
    }
}
