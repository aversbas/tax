package dao.daoImpl;

import dao.ConnectionFactory;
import dao.idao.ITaxiRideDao;
import entyties.Street;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alexm on 20.09.2019.
 */
public class TaxiRideDaoImpl implements ITaxiRideDao {

    @Override
    public double getSumKm(Street startAddress, Street endAddress) {

        double km = 0;
        long startId = startAddress.getId();
        long destId = endAddress.getId() - 1;
        long temp = 0;

        if (destId < startId) {
            temp = startId;
            startId = destId;
            destId = temp;
        }

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT start_id, dest_id, sum(km)\n" +
                    "FROM taxi_ride\n" +
                    "    JOIN streets s ON taxi_ride.start_id = s.id\n" +
                    "    JOIN streets s1 ON taxi_ride.dest_id=s1.id\n" +
                    "WHERE start_id BETWEEN ? AND ?;");
            stmt.setLong(1, startId);
            stmt.setLong(2, destId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                km = rs.getDouble(3);
            }
            return km;
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

        return 0;
    }
}
