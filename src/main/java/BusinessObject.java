import dao.daoImpl.UserActionDaoImpl;
import entyties.Action;
import entyties.TaxiRide;
import mysql.MySqlDaoFactory;

/**
 * Created by alexm on 09.08.2019.
 */
public class BusinessObject {

    public static void main(String[] args) throws Exception {

        MySqlDaoFactory mySqlDaoFactory = new MySqlDaoFactory();
        TaxiRide taxiRide;
//
//        MySQLCarDAO mySQLCarDAO = new MySQLCarDAO(mySqlDaoFactory.getContext());
//        MySQLUserDao mySQLUserDao = new MySQLUserDao(mySqlDaoFactory.getContext());
//     //   mySQLUserDao.getAll().forEach(System.out :: println);
//        mySQLCarDAO.getAll().forEach(System.out :: println);
//       // System.out.println(mySQLUserDao.getByPK(1));

//        MySQLTaxiRideDao mySQLTaxiRideDao = new MySQLTaxiRideDao(mySqlDaoFactory.getContext());
//
//        Distance distance = new Distance();
//        distance.calculate(mySQLTaxiRideDao.getByPK(2),mySQLTaxiRideDao.getByPK(2));
//        distance.price(mySQLTaxiRideDao.getByPK(2),mySQLTaxiRideDao.getByPK(2));
////        distance.discountTrip();

//        Discount discount = new Discount();
//        discount.discountCalculate();
//        TaxiDaoImpl taxiDao = new TaxiDaoImpl();
//        taxiDao.getAllCars().forEach(System.out :: println);
//        System.out.println(taxiDao.getCarByCarType("minivan"));
//        System.out.println(taxiDao.getCarById(1));
//        taxiDao.getAllAvailableCars().forEach(System.out::println);
//        StreetDaoImpl streetDao = new StreetDaoImpl();
//        System.out.println(streetDao.getStreetIdByName("Shuseva"));
//        UserDaoImpl userDao = new UserDaoImpl();
//        userDao.getAllUsers().forEach(System.out :: println);
        Action action = new Action();

        UserActionDaoImpl userActionDao = new UserActionDaoImpl();
        System.out.println(userActionDao.getUserActionByAction(action));

//        UserDaoImpl userDao = new UserDaoImpl();
//        System.out.println(userDao.getUserById(2));
    }


}
