package dao.daoImpl;

import dao.util.ConnectionFactory;
import dao.idao.IStreetDao;
import entyties.Street;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StreetDaoImpl implements IStreetDao {
    Logger log = Logger.getLogger(StreetDaoImpl.class);

    @Override
    public Street getById(long id) {

        String sql = "SELECT * FROM streets WHERE id=?";
        ResultSet rs = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Street street = new Street();
                street.setId(rs.getLong(1));
                street.setName(rs.getString(2));

                return street;
            }
            return null;
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public Long getStreetIdByName(String name) {
        long id = 0;
        String sql = "SELECT * FROM streets WHERE streetName=?";
        ResultSet rs = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException e) {
            log.error(e);
        }
        return id;
    }

    @Override
    public List<Street> getAllStreets() {
        List<Street> streets = new ArrayList<Street>();
        String sql = "SELECT * FROM streets";
        ResultSet rs = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            rs = stmt.executeQuery();
            Street street = new Street();
            while (rs.next()) {
                long id = rs.getLong(1);
                String name = rs.getString(2);
                Street st = new Street(name);
                st.setId(id);
                street.setId(rs.getLong(1));
                street.setName(rs.getString(2));
                streets.add(st);
            }
            return streets;
        } catch (SQLException e) {
            log.error(e);
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
