package com.example.demo14;

import java.sql.*;
public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + bdHost + ":"
                + bdPort +"/" +bdName + "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        dbConnection = DriverManager.getConnection(connectionString, bdUser, bdPass);
        return dbConnection;
    }
    public void signUpUser(String firstName, String lastName, String userName, String password){

        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," +
                Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + ")" + "VALUES(?,?,?,?)";



        try {
            PreparedStatement prST = getDbConnection().prepareStatement(insert);
            prST.setString(1,firstName);
            prST.setString(2,lastName);
            prST.setString(3,userName);
            prST.setString(4,password);
            prST.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
