package dao.idao;

import dao.PersistException;
import entyties.Taxi;
import entyties.Street;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public interface ITaxiDao {
    public List<Taxi> parseResultSet(ResultSet rs) throws PersistException;
    List<Taxi> getAllCars() throws PersistException;
    List<Taxi> getAllAvailableCars();
    Taxi getCarByCarType(String type) throws PersistException;

//    List<Taxi> getCarByCarType() throws PersistException;

    Taxi getCarById(long id);
    void setCarBusy(Taxi taxi);
    void setCarFree(Taxi taxi);
    void changeCurrentPos(Taxi taxi, Street street);
}
