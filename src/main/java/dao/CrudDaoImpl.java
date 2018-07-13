package dao;

import connect.Connect;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CrudDaoImpl implements CrudDao {

    @Override
    public void getCreateUpdateDelete(Connect dbc, String query) {
        try {
            int i = dbc.getStatement().executeUpdate(query);
            System.out.println("\nУспешно, было изменено: " + i + " строк\n");

        } catch (SQLException e) {
            System.out.println("\n" + e + "\n");
        }
    }

    @Override
    public void getRead(Connect dbc, String query) {
            try {
                ResultSet resultSet = dbc.getStatement().executeQuery(query);
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int i = resultSetMetaData.getColumnCount();

                while (resultSet.next()) {
                    for (int j = 1; j < i + 1; j++) {
                        System.out.print(resultSet.getString(j) + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            } catch (SQLException e) {
                System.out.println("\n" + e + "\n");
            }
    }
}
