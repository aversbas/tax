package dao.idao;

import entyties.Action;
import entyties.User;

/**
 * Created by alexm on 20.09.2019.
 */
public interface IActionDao {
    Action getUserAction(User user);
    void addSumToAction(User user, Action action, double sum);
    void takeSumFromAction(User user, Action action, double sum);
    void addNewAction(Action action);
}
