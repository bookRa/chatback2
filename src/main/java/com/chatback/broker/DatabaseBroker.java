package com.chatback.broker;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

import static java.sql.DriverManager.getConnection;

public class DatabaseBroker
{

    public void getMessages(String id)
    {
        // This SQL statement produces all table
        // names and column names in the H2 schema
        String sql = "select table_name, column_name " +
                "from information_schema.columns " +
                "order by " +
                "table_catalog, " +
                "table_schema, " +
                "table_name, " +
                "ordinal_position";

        connectToDatabase(sql);


    }

    private void connectToDatabase(String sql) {
        try (Connection c = getConnection(
                "localhost:3307",
                "root", "installedSQL9")) {

            Statement statement = c.createStatement();

            ResultSet set = statement.executeQuery(sql);


        }
        catch (Exception e)
        {
            Logger.getAnonymousLogger().info(e.getLocalizedMessage());
        }
    }
}
