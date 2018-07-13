package auth;

import java.util.Properties;
import java.util.Scanner;
public class SignIn {

    private Scanner in = new Scanner(System.in);

    public Properties getArrayConnectData() {

        Properties properties = new Properties();

        System.out.print("Введите адрес сервера: ");
        properties.put("host", in.nextLine());

        System.out.print("Введите порт: ");
        properties.put("port", in.nextLine());

        System.out.print("Введите логин: ");
        properties.put("user", in.nextLine());

        System.out.print("Введите пароль: ");
        properties.put("password", in.nextLine());

        return properties;

    }
}
