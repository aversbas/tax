package dao.daoImpl;

import dao.ConnectionFactory;
import dao.idao.ITaxiDao;
import dao.idao.IStreetDao;
import entyties.Taxi;
import entyties.Street;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public class TaxiDaoImpl implements ITaxiDao {

    private IStreetDao streetDao = new StreetDaoImpl();

    @Override
    public List<Taxi> getAllCars() {

        List<Taxi> taxis = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM taxi");
            rs = stmt.executeQuery();
            //Taxi taxi = new Taxi();
            while (rs.next()) {
                int id = rs.getInt(1);
                String taxiClass = rs.getString(2);
                Street curPos = new Street();
                curPos.setId(rs.getLong(3));
                curPos.setName(streetDao.getById(id).getName());
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
    public Taxi getCarByCarType(String carType) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM taxi WHERE class=? and is_free=1");
//            stmt.setString(1, carType);
            rs = stmt.executeQuery();
            // Taxi taxi = new Taxi();
            if (rs.next()) {
                int id = rs.getInt(1);
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
