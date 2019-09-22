package mysql;

/**
 * Created by alexm on 12.08.2019.
 */
public class MySQLUserDao  {

//    extends DAOFactory<User, Integer>

//    private class PersistUser extends User {
//        public void setId(int id) {
//            super.setId(id);
//        }
//    }
//
//    public MySQLUserDao(Connection connection) {
//        super(connection);
//    }
//
//    @Override
//    public User create() throws PersistException {
//        User user = new User();
//        return persist(user);
//    }
//
//    @Override
//    public String getSelectQuery() {
//        return "SELECT id, login, password, first_name, last_name,taxi_ride FROM user";
//    }
//
//    @Override
//    public String getCreateQuery() {
//        return "INSERT INTO user (login, password, first_name, last_name,taxi_ride) \n" +
//                "VALUES (?, ?, ?, ?, ?);";
//    }
//
//    @Override
//    public String getUpdateQuery() {
//        return "UPDATE user \n" +
//                "SET login = ?, password  = ?, first_name = ?, last_name = ?, taxi_ride = ? \n" +
//                "WHERE id = ?;";
//    }
//
//    @Override
//    public String getDeleteQuery() {
//        return "DELETE FROM user WHERE id= ?;";
//    }
//
//    @Override
//    protected List<User> parseResultSet(ResultSet rs) throws PersistException {
//        LinkedList<User> result = new LinkedList<User>();
//        try {
//            while (rs.next()) {
//                PersistUser persistUser = new PersistUser();
//                persistUser.setId(rs.getInt("id"));
//                persistUser.setLogin(rs.getString("login"));
//                persistUser.setPassword(rs.getString("password"));
//                persistUser.setFirst_name(rs.getString("first_name"));
//                persistUser.setLast_name(rs.getString("last_name"));
//                persistUser.setTaxi_ride(rs.getString("taxi_ride"));
//                result.add(persistUser);
//            }
//        } catch (Exception e) {
//            throw new PersistException(e);
//        }
//        return result;
//    }
//
//    @Override
//    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws PersistException {
//        try {
//            int user_type = (object.getId() == null) ? 0 : object.getId();
//
//            statement.setString(1, object.getLogin());
//            statement.setString(2, object.getPassword());
//            statement.setString(3, object.getFirst_name());
//            statement.setString(4, object.getLast_name());
//            statement.setString(5, object.getTaxi_ride());
//        } catch (Exception e) {
//            throw new PersistException(e);
//        }
//    }
//
//    @Override
//    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws PersistException {
//        try {
//            statement.setString(1, object.getLogin());
//            statement.setString(2, object.getPassword());
//            statement.setString(3, object.getFirst_name());
//            statement.setString(4, object.getLast_name());
//            statement.setString(5, object.getTaxi_ride());
//            statement.setInt(6, object.getId());
//        } catch (Exception e) {
//            throw new PersistException(e);
//        }
//    }
}
