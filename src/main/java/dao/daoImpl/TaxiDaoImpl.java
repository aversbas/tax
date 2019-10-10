package dao.daoImpl;

import dao.util.ConnectionFactory;
import dao.util.PersistException;
import dao.idao.IStreetDao;
import dao.idao.ITaxiDao;
import entyties.Street;
import entyties.Taxi;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TaxiDaoImpl implements ITaxiDao {

    Logger log = Logger.getLogger(TaxiDaoImpl.class);

    private IStreetDao streetDao = new StreetDaoImpl();

    public List<Taxi> parseResultSet(ResultSet rs) throws PersistException {
        Street street = new Street();
        LinkedList<Taxi> result = new LinkedList<>();

        try {
            while (rs.next()) {
                Taxi car = new Taxi();
                car.setId(rs.getInt(1));
                car.setCarClass(rs.getString(2));
//                street = streetDao.getById(rs.getInt(3));
                car.setIs_free(rs.getBoolean(4));

                result.add(car);
            }
        } catch (Exception e) {
            log.error(e);
        }
        return result;
    }

    @Override
    public List<Taxi> getAllCars()  {

        String sql = "SELECT * FROM taxi";
        ResultSet rs = null;
        List<Taxi> list = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            rs = stmt.executeQuery(sql);
            list = parseResultSet(rs);
        } catch (Exception e) {
            log.error(e);
        }
        return list;

    }

    @Override
    public List<Taxi> getAllAvailableCars() {
        List<Taxi> taxis = new ArrayList<>();
        String sql = "SELECT * FROM taxi WHERE is_free = 1 group by class";
        ResultSet rs = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String taxiClass = rs.getString(2);
                Street curPos = streetDao.getById(rs.getInt(3));
                int is_free = rs.getInt(4);
                boolean isFree = is_free==1;
                Taxi tx = new Taxi();
                tx.setId(id);
                tx.setCarClass(taxiClass);
                tx.setCurr_pos(curPos);
                tx.setIs_free(isFree);

                taxis.add(tx);

            }
            return taxis;
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }


    @Override
    public Taxi getCarByCarType(String carClass){

        ResultSet rs = null;
        List<Taxi> list = null;
        String sql = "SELECT * FROM taxi WHERE is_free = 1 AND class = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,carClass);
            rs = stmt.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            log.error(e);
        }
       return list.iterator().next();
    }

    @Override
    public Taxi getCarById(long id) {

        String sql = "SELECT * FROM taxi WHERE id=?";
        ResultSet rs = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String taxiClass = rs.getString(2);
                Street curPos = new Street();
                int  streetId = rs.getInt(3);
                curPos.setId(rs.getLong(3));
                curPos.setName(streetDao.getById(streetId).getName());
                int is_free = rs.getInt(4);
                boolean isFree = is_free==1;
                Taxi tx = new Taxi();
                tx.setId(id);
                tx.setCarClass(taxiClass);
                tx.setCurr_pos(curPos);
                tx.setIs_free(isFree);
                return tx;
            }
            return null;
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public void setCarBusy(Taxi taxi) {

        String sql = "UPDATE taxi SET is_free=0 WHERE id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, taxi.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public void setCarFree(Taxi taxi) {

        String sql = "UPDATE taxi SET is_free=1 WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, taxi.getId());
            stmt.executeUpdate();


        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public void changeCurrentPos(Taxi taxi, Street street) {

        String sql = "UPDATE taxi SET curr_pos=? WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, street.getName());
            stmt.setLong(2, taxi.getId());
            stmt.executeUpdate();


        } catch (SQLException e) {
            log.error(e);
        }
    }
}
