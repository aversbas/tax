package dao.idao;

import entyties.Action;
import entyties.User;

public interface IActionDao {
    /**
     * @param user
     * @return
     */
    Action getUserAction(User user);

    /**
     * @param user
     * @param action
     * @param sum
     */
    void addSumToAction(User user, Action action, double sum);

    /**
     * @param user
     * @param action
     * @param sum
     */
    void takeSumFromAction(User user, Action action, double sum);

    /**
     * @param action
     */
    void addNewAction(Action action);
}
