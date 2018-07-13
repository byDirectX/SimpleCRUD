/**
 * UPD 0.3
 * Refactoring
 *
 * UPD 0.2
 * It is possible to move a string
 * The query is executed when you enter a semicolon
 * The word USE is available in upper and lower case
 * The word USE is available in upper and lower case
 * It is possible to use the word QUIT to exit from programm
 *
 *
 * Used to work with the MySQL database <br>
 * Send a request for the key enter. <br>
 * Line feed does not work, semicolon is not required. <br>
 * @author bydirectx (Artyom Bondarev) <br>
 * @version 0.3 <br>
 */

package service;

import connect.Connect;
import dao.CrudDaoImpl;
import auth.Login;

import java.util.Scanner;

public class RunnerCrud {
    public static void main(String[] args) {

        CrudDaoImpl crud = new CrudDaoImpl();
        Login login = new Login();

        Connect dbc = null;
        Scanner in = new Scanner(System.in);

        dbc = login.getConnect();

        String query;

        do {
            query = "";
            System.out.println("Введите команду: ");
            while (true) {
                query += in.nextLine();
                if (query.charAt(query.length() - 1) == ';') break;
            }

            if (query.toUpperCase().equals("RECONNECT;")) {
                System.out.println();
                dbc = login.getConnect();
                continue;
            }

            if (query.toUpperCase().equals("EXIT;") || query.toUpperCase().equals("QUIT;")) {
                break;
            }

            String resultCrud = query.substring(0, query.indexOf(' '));

            if (resultCrud.equals("SHOW") || resultCrud.equals("DESCRIBE") || resultCrud.equals("SELECT")) {
                crud.getRead(dbc, query);
            } else {
                crud.getCreateUpdateDelete(dbc, query);
            }
        } while (true);

        dbc.closeStatement(dbc.getStatement());

    }
}
