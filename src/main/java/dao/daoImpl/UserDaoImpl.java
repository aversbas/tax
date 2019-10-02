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

    public long getIdByUserName(String name) {
        int id = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT id FROM users WHERE user_name = ?");
            stmt.setString(1,name);
            rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
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
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    log.error("error geting user: " + e.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    log.error("connection error: " + e.getMessage());
                }
            }
        }


        return id;
    }


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
                user.setUserName(rs.getString(3));
                user.setUserMail(rs.getString(2));
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

    public long save(User user) {
        String userName = user.getUserName();
        String email = user.getUserMail();
        //String password = MD5.getMD5(user.getUserPassword());
        String password = user.getUserPassword();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement("INSERT INTO users "
                    + "(user_email, user_name, user_password) VALUES "
                    + "(?, ?, ?)");
            statement.setString(1, user.getUserMail());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getUserPassword());

            log.info("user saved");

            return statement.executeUpdate();

        } catch (SQLException e) {
            return -1;
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
            log.info("MySQLUserDAO.insertUser() cannot close statement");
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                   log.info("MySQLUserDAO.insertUser() cannot close connection");
                }
            }
        }
    }

    public void update(User user) {

    }

    public void delete(User user) {

    }

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
                log.info("rs block");



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


                user.setUserId(rs.getLong("id"));
                user.setUserName(rs.getString("userName"));
                user.setUserMail(rs.getString("userEmail"));
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
}
