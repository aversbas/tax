import entyties.TaxiRide;
import mysql.MySqlDaoFactory;
import service.discountandpromotion.Discount;

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

        Discount discount = new Discount();
        discount.discountCalculate();
    }


}
