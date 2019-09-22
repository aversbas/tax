package mysql;

/**
 * Created by alexm on 12.08.2019.
 */
public class MySQLCarDAO  {

 //   extends DAOFactory<Taxi, Integer>
//    private class PersistGroup extends Taxi {
//        public void setId(int id) {
//            super.setIdCar(id);
//        }
//    }

//    public MySQLCarDAO(Connection connection) {
//        super(connection);
//    }

//    @Override
//    public Taxi create() throws PersistException {
//        Taxi car = new Taxi();
//        return persist(car);
//    }
//
//    @Override
//    public String getSelectQuery() {
//        return "SELECT id_car, type, model, color FROM car";
//    }
//
//    @Override
//    public String getCreateQuery() {
//        return "INSERT INTO car (type, model, color) \n" +
//                "VALUES (?, ?, ?);";
//    }
//
//    @Override
//    public String getUpdateQuery() {
//        return "UPDATE car SET type= ? model = ? color = ?  WHERE id_car= ?;";
//    }
//
//    @Override
//    public String getDeleteQuery() {
//        return "DELETE FROM car WHERE id_car= ?;";
//    }
//
//    @Override
//    protected List<Taxi> parseResultSet(ResultSet rs) throws PersistException {
//        LinkedList<Taxi> result = new LinkedList<>();
//        try {
//            while (rs.next()) {
//                PersistGroup car = new PersistGroup();
//                car.setId(rs.getInt("id_car"));
//                car.setType(rs.getString("type"));
//                car.setModel(rs.getString("model"));
//                car.setColor(rs.getString("color"));
//                result.add(car);
//            }
//        } catch (Exception e) {
//            throw new PersistException(e);
//        }
//        return result;
//    }
//
//    @Override
//    protected void prepareStatementForInsert(PreparedStatement statement, Taxi object) throws PersistException {
//        try {
//            statement.setString(1, object.getType());
//            statement.setString(2, object.getModel());
//            statement.setString(2, object.getColor());
//        } catch (Exception e) {
//            throw new PersistException(e);
//        }
//    }
//
//    @Override
//    protected void prepareStatementForUpdate(PreparedStatement statement, Taxi object) throws PersistException {
//        try {
//            statement.setString(1, object.getType());
//            statement.setString(2, object.getModel());
//            statement.setString(2, object.getColor());
//            statement.setInt(3, object.getId());
//        } catch (Exception e) {
//            throw new PersistException(e);
//        }
//    }
}
