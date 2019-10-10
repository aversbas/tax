package dao.idao;

import entyties.Street;
import entyties.Taxi;

import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public interface ITaxiDao {
    /**
     * @return
     */
    List<Taxi> getAllCars();

    /**
     * @return
     */
    List<Taxi> getAllAvailableCars();

    /**
     * @param type
     * @return
     */
    Taxi getCarByCarType(String type);

    /**
     * @param id
     * @return
     */
    Taxi getCarById(long id);

    /**
     * @param taxi
     */
    void setCarBusy(Taxi taxi);

    /**
     * @param taxi
     */
    void setCarFree(Taxi taxi);

    /**
     * @param taxi
     * @param street
     */
    void changeCurrentPos(Taxi taxi, Street street);
}
