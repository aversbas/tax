package dao.idao;

import entyties.Street;

import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public interface IStreetDao {
    Street getById(long id);
    int getStreetIdByName(String name);
    List<Street> getAllStreets();
    void save (Street street);
    void update (Street street);
    void delete (Street street);
}
