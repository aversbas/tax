package dao.daoImpl;

import dao.ConnectionFactory;
import dao.PersistException;
import dao.idao.IStreetDao;
import dao.idao.ITaxiDao;
import entyties.Street;
import entyties.Taxi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public class TaxiDaoImpl implements ITaxiDao {

    private IStreetDao streetDao = new StreetDaoImpl();


    public String getSelectQuery() {return "SELECT * FROM taxi";}

    @Override
    public List<Taxi> parseResultSet(ResultSet rs) throws PersistException {
        Street street = new Street();
        LinkedList<Taxi> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Taxi car = new Taxi();
                Street curPos = new Street();

                car.setId(rs.getInt(1));
                car.setCarClass(rs.getString(2));
//                Street currrentPos = new Street();
//                curPos.setName(String.valueOf(streetDao.getAllStreets()));
                car.setIs_free(rs.getBoolean(4));

                result.add(car);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    public List<Taxi> getAllCars() throws PersistException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Taxi> list;
        String sql = getSelectQuery();
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM taxi");
            rs = stmt.executeQuery(sql);
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;


//        List<Taxi> taxis = new ArrayList<>();
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        try {
//            conn = ConnectionFactory.getConnection();
//            stmt = conn.prepareStatement("SELECT * FROM taxi");
//            rs = stmt.executeQuery();
//            //Taxi taxi = new Taxi();
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String taxiClass = rs.getString(2);
//                Street curPos = new Street();
//                curPos.setId(rs.getLong(3));
//                curPos.setName(streetDao.getById(id).getName());
//                int is_free = rs.getInt(4);
//                boolean isFree = is_free==1;
//                Taxi tx = new Taxi();
//                tx.setId(id);
//                tx.setCarClass(taxiClass);
//                tx.setCurr_pos(curPos);
//                tx.setIs_free(isFree);
//
//                taxis.add(tx);
//
//            }
//            return taxis;
//        } catch (SQLException e) {
//            e.getMessage();
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.getMessage();
//                }
//            }
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.getMessage();
//                }
//            }
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.getMessage();
//                }
//            }
//        }
//        return null;
    }

    @Override
    public List<Taxi> getAllAvailableCars() {
        List<Taxi> taxis = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM taxi WHERE is_free = 1 group by class");
            rs = stmt.executeQuery();
            //Taxi taxi = new Taxi();
            while (rs.next()) {
                int id = rs.getInt(1);
                String taxiClass = rs.getString(2);
                Street curPos = streetDao.getById(rs.getInt(3)); //new Street();
                // curPos.setId(rs.getInt(3));
                //
                //curPos.setName(streetDao.getById(id).getName());
                //
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
    public Taxi getCarByCarType(String carClass){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Taxi> list = null;
        String sql = getSelectQuery();
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM taxi WHERE class=? and is_free=1");
//            stmt.setString(1, carType);
            rs = stmt.executeQuery(sql);
            list = parseResultSet(rs);
        } catch (Exception e) {
            try {
                throw new PersistException(e);
            } catch (PersistException e1) {
                e1.printStackTrace();
            }
        }
       return list.iterator().next();
    }

    @Override
    public Taxi getCarById(long id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM taxi WHERE id=?");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            // Taxi taxi = new Taxi();
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
    public void setCarBusy(Taxi taxi) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("UPDATE taxi SET is_free=0 WHERE id=?");
            stmt.setLong(1, taxi.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
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
    public void setCarFree(Taxi taxi) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("UPDATE taxi SET is_free=1 WHERE id=?");
            stmt.setLong(1, taxi.getId());
            stmt.executeUpdate();


        } catch (SQLException e) {
            e.getMessage();
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
    public void changeCurrentPos(Taxi taxi, Street street) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("UPDATE taxi SET curr_pos=? WHERE id=?");
            stmt.setLong(1, street.getId());
            stmt.setLong(2, taxi.getId());
            stmt.executeUpdate();


        } catch (SQLException e) {
            e.getMessage();
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
}
