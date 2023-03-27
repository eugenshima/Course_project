package org.example.dao;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionFactory extends Config {
    public static Connection dbConnection = null;

    ArrayList<String[]> masResult;

    private Statement statement;

    private ResultSet rs;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String con = "jdbc:mysql://"+ dbHost +":" + dbPort + "/"+dbName;
        dbConnection = DriverManager.getConnection(con, dbUser, dbPass);
        return dbConnection;
    }

    public ArrayList<String[]> getArrayResult(String str) {
        masResult = new ArrayList<String[]>();
        try {
            rs = statement.executeQuery(str);
            int count = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                String[] arrayString = new String[count];
                for (int i = 1;  i <= count; i++)
                    arrayString[i - 1] = rs.getString(i);

                masResult.add(arrayString);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return masResult;
    }



}
