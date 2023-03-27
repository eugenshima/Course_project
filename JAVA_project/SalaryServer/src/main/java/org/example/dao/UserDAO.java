package org.example.dao;

import org.example.interfaces.UserSQL;
import org.example.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends ConnectionFactory implements UserSQL {
    PreparedStatement prST = null;

    ResultSet rs;

    int st; //status
    @Override
    public User getUser(User user) {
        ResultSet rs =null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +Const.LOGIN + "=? AND "+Const.PASS+ "=?";
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(select);
            ps.setString(1, user.getUserLogin());
            ps.setString(2, user.getUserPassword());
            rs=ps.executeQuery();
            while(rs.next()){
                user.setIduser(rs.getInt("UID"));
                user.setUserLogin(rs.getString("Login"));
                user.setUserPassword(rs.getString("Password"));
                user.setPersonID(rs.getInt("PersonID"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return user;

    }

    @Override
    public void regUser(User user) {
        String insert;
        ResultSet rs = null;
        insert = "INSERT INTO users(" + Const.LOGIN + ", PersonID, " + Const.PASS + ") VALUES(?,?,?)";
        try {
            prST = getDbConnection().prepareStatement(insert);
            prST.setString(1, user.getUserLogin());
            prST.setInt(2, user.getPersonID());
            prST.setString(3, user.getUserPassword());
            st = prST.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public ArrayList<User> searchUser(User user) {
        ArrayList<User> arrayList = new ArrayList<>();
        return arrayList;
    }

    @Override
    public boolean ifExists(User user) {
        boolean result = true;
        ResultSet rs =null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.LOGIN + "=?";
        try {
            prST = getDbConnection().prepareStatement(select);
            prST.setString(1, user.getUserLogin());
            rs=prST.executeQuery();
            if(rs.next()) {
                result = false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


}
