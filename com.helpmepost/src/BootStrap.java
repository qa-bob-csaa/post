/**
 * Created by gn11sma on 5/14/2016.
 */
public class BootStrap {
    public void main () {
        String sessionID = null;
        System.out.println("Need to verify Internet connection");
        System.out.println("Need to call server for unique session ID");
        Login login = new Login();
        login.main(sessionID);

    }
}
