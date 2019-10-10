package dao.idao;

import entyties.Street;

import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public interface IStreetDao {
    /**
     * @param id
     * @return
     */
    Street getById(long id);

    /**
     * @param name
     * @return
     */
    Long getStreetIdByName(String name);

    /**
     * @return
     */
    List<Street> getAllStreets();

    /**
     * @param street
     */
    void save (Street street);

    /**
     * @param street
     */
    void update (Street street);

    /**
     * @param street
     */
    void delete (Street street);
}
