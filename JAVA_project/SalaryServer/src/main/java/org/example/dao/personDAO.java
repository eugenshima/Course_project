package org.example.dao;

import org.example.interfaces.personSQL;
import org.example.model.Person;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class personDAO extends ConnectionFactory implements personSQL {
    private ConnectionFactory Connection;
    ResultSet rs;
    PreparedStatement prST = null;
    int st;
    public void RegPerson(Person person) {
        String insert;
        ResultSet rs = null;
        insert = "INSERT INTO " + Const.PERSON_TABLE +"(" + Const.USERFNAME+ "," + Const.USERLNAME + "," + Const.USER_PHONE + "," + Const.USERMAIL+ ") VALUES(?,?,?,?)";
        try{
            prST = getDbConnection().prepareStatement(insert);
            prST.setString(1, person.getUserFName());
            prST.setString(2, person.getUserLName());
            prST.setString(3, person.getPhoneNumber());
            prST.setString(4, person.getEmail());

            st = prST.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person getPerson(Person person) {
        String select = "SELECT * FROM "+ Const.PERSON_TABLE +" WHERE "+Const.USERFNAME+"=?";
        try {
            prST = getDbConnection().prepareStatement(select);
            prST.setString(1, person.getUserFName());
            rs=prST.executeQuery();
            while (rs.next()) {
                person.setID(rs.getInt("ID"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    @Override
    public void DelPerson(Person person) {
        String delete;
        delete = "DELETE FROM " + Const.PERSON_TABLE + " WHERE ID=?";
        try {
            prST = getDbConnection().prepareStatement(delete);
            prST.setInt(1, person.getID());
            st = prST.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
