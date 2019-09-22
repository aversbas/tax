package dao.idao;

import entyties.Taxi;
import entyties.Street;

import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public interface ITaxiDao {
    List<Taxi> getAllCars();
    List<Taxi> getAllAvailableCars();
    Taxi getCarByCarType(String type);
    Taxi getCarById(long id);
    void setCarBusy(Taxi taxi);
    void setCarFree(Taxi taxi);
    void changeCurrentPos(Taxi taxi, Street street);
}
