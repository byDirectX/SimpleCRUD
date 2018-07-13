package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connect {

    private String URL;
    private String USER;
    private String PASSWORD;
    private String DBNAME;
    private Connection connect = null;
    private boolean testConnection = false;

    public Connect(String dbname, Properties conData) {
        DBNAME = dbname;
        URL = "jdbc:mysql://" + conData.getProperty("host") + ":" + conData.getProperty("port") + "/" + dbname;
        USER = conData.getProperty("user");
        PASSWORD = conData.getProperty("password");
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            testConnection = true;
            System.out.println("\n***************************");
            System.out.println("Вы успешно подключились");
            System.out.println("База данных: " + DBNAME);
            System.out.println("Введите \"exit;\" или \"quit;\" для выхода");
            System.out.println("Введите \"reconnect;\" для переподключения к БД");
            System.out.println("***************************\n");
        } catch (SQLException e) {
            System.out.println("\nОшибка подключения к БД. Проверьте правильность данных.");
            System.out.println("Введите данные повторно\n");
        }
    }

    public boolean getTestConnection() {
        return testConnection;
    }

    public Statement getStatement() {
        Statement st = null;
        try {
            st = connect.createStatement();
        } catch (SQLException e) {
            System.out.println("Ошибка Statement");
        }
        return st;
    }

    public boolean closeStatement(Statement st) {
        boolean b = false;
        try {
            if (st != null) {
                st.close();
                b = true;
            }
        } catch (SQLException e) {
            System.out.println("Ошибка закрытия сессии.");
        }
        return b;
    }
}
