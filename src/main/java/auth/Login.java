package auth;

import connect.Connect;

import java.util.Properties;

public class Login {

    private Connect dbc = null;
    private Properties conData = null;
    private String dbname = "";
    private SignIn signIn = new SignIn();

    public Connect getConnect() {
        while (true) {
            conData = signIn.getArrayConnectData();
            dbc = new Connect(dbname, conData);
            if (dbc.getTestConnection() == true) {
                break;
            }
        }
        return dbc;
    }
}
