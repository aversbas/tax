package dao.idao;

import entyties.Street;
import entyties.Taxi;

import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public interface ITaxiDao {
//    public List<Taxi> parseResultSet(ResultSet rs);
    List<Taxi> getAllCars();
    List<Taxi> getAllAvailableCars();
    Taxi getCarByCarType(String type);
    Taxi getCarById(long id);
    void setCarBusy(Taxi taxi);
    void setCarFree(Taxi taxi);
    void changeCurrentPos(Taxi taxi, Street street);
}
