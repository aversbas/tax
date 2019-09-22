package mysql;

/**
 * Created by alexm on 12.08.2019.
 */
public class MySqlDaoFactory {

//    implements InterDaoFactory<Connection>

    //   private static final Logger LOGGER = Logger.getLogger(MySQLUserDao.class.getSimpleName());
//    private String url = "jdbc:mysql://localhost:3306/jdbc";
//    private String user = "root";
//    private String password = "root";
//    private String driver = "com.mysql.jdbc.Driver";
//    private Map<Class, DaoCreator> creators;
//
//    public Connection getContext() throws PersistException {
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(url, user, password);
//        } catch (SQLException e) {
//            throw new PersistException(e);
//        }
//        return  connection;
//    }
//
//    @Override
//    public GenericDao getDao(Connection connection, Class dtoClass) throws PersistException {
//        DaoCreator creator = creators.get(dtoClass);
//        if (creator == null) {
//            throw new PersistException("Dao object for " + dtoClass + " not found.");
//        }
//        return creator.create(connection);
//    }
//
//    public MySqlDaoFactory() {
//        try {
//            Class.forName(driver);//Регистрируем драйвер
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        creators = new HashMap<Class, DaoCreator>();
//        creators.put(Taxi.class, new DaoCreator<Connection>() {
//            @Override
//            public GenericDao create(Connection connection) {
//                return new MySQLCarDAO(connection);
//            }
//        });
//        creators.put(User.class, new DaoCreator<Connection>() {
//            @Override
//            public GenericDao create(Connection connection) {
//                return new MySQLUserDao(connection);
//            }
//        });
//    }
}

