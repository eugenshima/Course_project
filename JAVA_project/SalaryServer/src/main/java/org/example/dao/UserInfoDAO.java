package org.example.dao;

import org.example.interfaces.UserInfoSQL;
import org.example.model.Person;
import org.example.model.UserInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserInfoDAO extends ConnectionFactory implements UserInfoSQL {
    PreparedStatement prST = null;

    int st; //status
    ResultSet rs;

    @Override
    public ArrayList<UserInfo> get() {
        ArrayList<UserInfo> arrayList = new ArrayList<>();
        try {
            String select;
            select = "SELECT ID, UserFName, UserLName, PhoneNumber, Email, users.Login, users.Password, roles.URole \n" +
                    "FROM person \n" +
                    "JOIN users ON person.ID=users.PersonID\n" +
                    "JOIN roles ON person.ID=roles.PersonID;";
            prST = getDbConnection().prepareStatement(select);
            rs = prST.executeQuery();
            while (rs.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(rs.getInt("ID"));
                userInfo.setFName(rs.getString("UserFName"));
                userInfo.setLName(rs.getString("UserLName"));
                userInfo.setPhoneNumber(rs.getString("PhoneNumber"));
                userInfo.setEmail(rs.getString("Email"));
                userInfo.setLogin(rs.getString("Login"));
                userInfo.setPassword(rs.getString("Password"));
                userInfo.setRole(rs.getString("URole"));
                arrayList.add(userInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

}
