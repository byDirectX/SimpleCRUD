package dao;

import connect.Connect;

public interface CrudDao {

    public void getCreateUpdateDelete(Connect dbc, String query);

    public void getRead(Connect dbc, String query);

}
