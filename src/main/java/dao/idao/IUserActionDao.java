package dao.idao;

import dao.PersistException;
import entyties.Action;
import entyties.UserAction;

/**
 * Created by alexm on 20.09.2019.
 */
public interface IUserActionDao {
    UserAction getUserActionByAction(Action action) throws PersistException;
    void createnewUserAction(Action action);
}
