package entyties;

public class UserAction {

  private Long id;
  private User user;
  private Action action;

  public UserAction() {
  }

  public UserAction(User user, Action action) {
    this.user = user;
    this.action = action;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  @Override
  public String toString() {
    return "UserAction{" +
            "id=" + id +
            ", user=" + user +
            ", action=" + action +
            '}';
  }
}
