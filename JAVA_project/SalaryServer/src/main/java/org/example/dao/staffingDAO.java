package org.example.dao;

import org.example.interfaces.staffingSQL;
import org.example.model.Staffing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class staffingDAO extends ConnectionFactory implements staffingSQL {


    PreparedStatement prST = null;

    ResultSet rs = null;

    int st;

    @Override
    public ArrayList<Staffing> GetStaffingList() {
        ArrayList<Staffing> arrayList = new ArrayList<>();
        
        try {

            String select = "SELECT * FROM " + Const.STAFFING_TABLE;
            prST = getDbConnection().prepareStatement(select);
            rs = prST.executeQuery();
            while (rs.next()) {
                Staffing staffing = new Staffing();
                staffing.setIdStaffing(rs.getInt("ID"));
                staffing.setPersonID(rs.getInt("PersonID"));
                staffing.setRoleID(rs.getInt("RoleID"));
                staffing.setCasing(rs.getInt("Casing"));
                arrayList.add(staffing);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public void AddStaff(Staffing staffing) {
        String insert;
        insert = "INSERT INTO " + Const.STAFFING_TABLE + "(PersonID, RoleID," + Const.CASING + ") VALUES(?,?,?)";
        try {
            prST = getDbConnection().prepareStatement(insert);
            prST.setInt(1, staffing.getPersonID());
            prST.setInt(2,staffing.getRoleID());
            prST.setInt(3, staffing.getCasing());
            st=prST.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStaff(Staffing staffing) {

    }

    @Override
    public ArrayList<Staffing> searchStaff(Staffing staffing) {
        ArrayList<Staffing> arrayList = new ArrayList<>();
        return arrayList;
    }

    @Override
    public Staffing getCasing(Staffing staffing) {
        String select;
        select = "SELECT Casing FROM staffing WHERE ID=?";
        try {
            prST=getDbConnection().prepareStatement(select);
            prST.setInt(1,staffing.getIdStaffing());
            rs=prST.executeQuery();
            while(rs.next()){
                staffing.setCasing(rs.getInt("Casing"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return staffing;
    }
}
