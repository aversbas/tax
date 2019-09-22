package mysql;

/**
 * Created by alexm on 25.08.2019.
 */
public class MySQLTaxiRideDao  {
 //   extends DAOFactory<TaxiRide, Integer>

//    public MySQLTaxiRideDao(Connection connection) {
//        super(connection);
//    }
//
//    private class PersistTaxiRide extends TaxiRide {
//        public void setId(int id) {
//            super.setId(id);
//        }
//    }
//
//    @Override
//    public TaxiRide create() throws PersistException {
//        TaxiRide taxiRide = new TaxiRide();
//        return persist(taxiRide);
//    }
//
//    @Override
//    public String getSelectQuery() {
//        return "SELECT id, start_address, end_address FROM taxi_ride";
//    }
//
//    public String getSelectAddressStart(){
//        return "SELECT start_address FROM taxi_ride WHERE id= ?;";
//    }
//
//    public String getSelectAddressEnd(){
//        return "SELECT end_address FROM taxi_ride WHERE id= ?;";
//    }
//
//    @Override
//    public String getCreateQuery() {
//        return "INSERT INTO taxi_ride (start_address, end_address) \n" +
//                "VALUES (?, ?);";
//    }
//
//    @Override
//    public String getUpdateQuery() {
//        return "UPDATE taxi_ride \n" +
//                "SET start_address = ?, end_address  = ? \n" +
//                "WHERE id = ?;";
//    }
//
//    @Override
//    public String getDeleteQuery() {
//        return "DELETE FROM taxi_ride WHERE id= ?;";
//    }
//
//    @Override
//    protected List<TaxiRide> parseResultSet(ResultSet rs) throws PersistException {
//        LinkedList<TaxiRide> result = new LinkedList<>();
//        try {
//            while (rs.next()) {
//                PersistTaxiRide persistTaxiRide = new PersistTaxiRide();
//                persistTaxiRide.setId(rs.getInt("id"));
//                persistTaxiRide.setStartAddress(rs.getString("start_address"));
//                persistTaxiRide.setEndAddress(rs.getString("end_address"));
//                result.add(persistTaxiRide);
//            }
//        } catch (Exception e) {
//            throw new PersistException(e);
//        }
//        return result;
//    }
//
//    @Override
//    protected void prepareStatementForInsert(PreparedStatement statement, TaxiRide object) throws PersistException {
//        try {
//            int id = (object.getId() == null) ? 0 : object.getId();
//
//            statement.setString(1, object.getStartAddress());
//            statement.setString(2, object.getEndAddress());
//        } catch (Exception e) {
//            throw new PersistException(e);
//        }
//    }
//
//    @Override
//    protected void prepareStatementForUpdate(PreparedStatement statement, TaxiRide object) throws PersistException {
//        try {
//            statement.setString(1, object.getStartAddress());
//            statement.setString(2, object.getEndAddress());
//            statement.setInt(3, object.getId());
//        } catch (Exception e) {
//            throw new PersistException(e);
//        }
//    }
}
