package dao.daoImpl;

import dao.ConnectionFactory;
import dao.idao.IStreetDao;
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
public class StreetDaoImpl implements IStreetDao {

    @Override
    public Street getById(long id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM streets WHERE id=?");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            //Street street = null;
            if (rs.next()) {
                Street street = new Street();
                street.setId(rs.getLong(1));
                street.setName(rs.getString(2));

                return street;
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
    public Long getStreetIdByName(String name) {
        long id = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM streets WHERE streetName=?");
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
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
        return id;
    }

    @Override
    public List<Street> getAllStreets() {
        List<Street> streets = new ArrayList<Street>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM streets");
            rs = stmt.executeQuery();
            Street street = new Street();
            while (rs.next()) {
                long id = rs.getLong(1);
                String name = rs.getString(2);
                Street st = new Street(name);
                st.setId(id);
//                street.setId(rs.getInt(1));
//                street.setName(rs.getString(2));
                streets.add(st);
            }
            return streets;
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
    public void save(Street street) {

    }

    @Override
    public void update(Street street) {

    }

    @Override
    public void delete(Street street) {

    }
}
