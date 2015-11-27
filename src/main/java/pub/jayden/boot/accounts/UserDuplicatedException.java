package pub.jayden.boot.accounts;

/**
 * Created by jaydenuk on 2015. 11. 27..
 */
public class UserDuplicatedException extends RuntimeException {

    private String username ;
    public UserDuplicatedException(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
}
