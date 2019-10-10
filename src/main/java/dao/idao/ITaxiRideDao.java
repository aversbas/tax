package dao.idao;

import entyties.Street;

/**
 * Created by alexm on 20.09.2019.
 */
public interface ITaxiRideDao {
    /**
     * @param startAddress
     * @param endAddress
     * @return
     */
    double getSumKm(Street startAddress, Street endAddress);
}
