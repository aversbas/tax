package mysql;

import dao.ConnectionPool;
import dao.DAOFactory;
import dao.PersistException;
import entyties.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexm on 12.08.2019.
 */
public class MySQLUserDao  extends DAOFactory<User, Integer> {

    private class PersistUser extends User {
        public void setId(long id) {
            super.setUserId(id);
        }
    }

    public MySQLUserDao() {
        ConnectionPool.getInstance().getConnection();
    }

    @Override
    public User create() throws PersistException {
        User user = new User();
        return persist(user);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, user_name, user_password,user_email FROM users";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO users (user_name, user_password,user_email) \n" +
                "VALUES (?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE user \n" +
                "SET user_name = ?, user_password  = ?, user_email = ? \n" +
                "WHERE id = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM user WHERE id= ?;";
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<User> result = new LinkedList<User>();
        try {
            while (rs.next()) {
                PersistUser persistUser = new PersistUser();
                persistUser.setId(rs.getInt("id"));
                persistUser.setUserPassword(rs.getString("user_password"));
                persistUser.setUserName(rs.getString("user_name"));
                persistUser.setUserMail(rs.getString("user_email"));
                result.add(persistUser);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws PersistException {
        try {
            statement.setString(2, object.getUserMail());
            statement.setString(3, object.getUserName());
            statement.setString(4, object.getUserPassword());

        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws PersistException {
        try {
            statement.setString(2, object.getUserMail());
            statement.setString(3, object.getUserName());
            statement.setString(4, object.getUserPassword());
            statement.setLong(1, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
}
