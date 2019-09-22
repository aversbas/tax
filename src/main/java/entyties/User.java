package entyties;

import dao.Identified;

public class User implements Identified<Integer> {

  private Long userId;
  private String userName;
  private String userMail;
  private String userPassword;

  public User(String userName, String userMail, String userPassword) {
    this.userName = userName;
    this.userMail = userMail;
    this.userPassword = userPassword;
  }

  public User() {
  }

  @Override
  public Long getId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserMail() {
    return userMail;
  }

  public void setUserMail(String userMail) {
    this.userMail = userMail;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  @Override
  public String toString() {
    return "User{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", userMail='" + userMail + '\'' +
            ", userPassword='" + userPassword + '\'' +
            '}';
  }

}
