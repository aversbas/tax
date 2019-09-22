package service.authorization;

/**
 * Created by alexm on 18.09.2019.
 */
public class LoginService {
    public boolean validateUser(String user, String password) {
        return user.equalsIgnoreCase("in28Minutes") && password.equals("dummy");
    }
}
