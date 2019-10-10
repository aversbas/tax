package dao.idao;

import entyties.Action;
import entyties.UserAction;

/**
 * Created by alexm on 20.09.2019.
 */
public interface IUserActionDao {
    /**
     * @param action
     * @return
     */
    UserAction getUserActionByAction(Action action);

    /**
     * @param action
     */
    void createnewUserAction(Action action);
}
