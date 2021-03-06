package dao.daoImpl;

import dao.util.ConnectionFactory;
import dao.idao.ITaxiRideDao;
import entyties.Street;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxiRideDaoImpl implements ITaxiRideDao {

    Logger log = Logger.getLogger(TaxiRideDaoImpl.class);

    @Override
    public double getSumKm(Street startAddress, Street endAddress) {

        double km = 0;
        long startId = startAddress.getId();
        long destId = endAddress.getId()-1;
        long temp = 0;

        if (destId < startId) {
            temp = startId;
            startId = destId;
            destId = temp;
        }
        String sql = "SELECT start_id, dest_id, sum(km)\n" +
                     "FROM taxi_ride\n" +
                     "    JOIN streets s ON taxi_ride.start_id = s.id\n" +
                     "    JOIN streets s1 ON taxi_ride.dest_id=s1.id\n" +
                     "WHERE start_id BETWEEN ? AND ?";
        ResultSet rs = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, startId);
            stmt.setLong(2, destId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                km = rs.getDouble(2);
            }
            return km ;
        } catch (SQLException e) {
            log.error(e);
        }

        return 0;
    }
}


