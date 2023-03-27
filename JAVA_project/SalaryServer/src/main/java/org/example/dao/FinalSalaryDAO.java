package org.example.dao;

import org.example.interfaces.FinalSalarySQL;
import org.example.model.FinalSalary;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FinalSalaryDAO extends ConnectionFactory implements FinalSalarySQL {
    PreparedStatement prST = null;

    ResultSet rs = null;

    int st;
    @Override
    public ArrayList<FinalSalary> GetSalaryList() {
        ArrayList<FinalSalary> arrayList = new ArrayList<>();
        String select;
        select = "SELECT * FROM finalsalary";
        try {
            prST = getDbConnection().prepareStatement(select);
            rs=prST.executeQuery();
            while (rs.next()) {
                FinalSalary finalSalary = new FinalSalary();
                finalSalary.setIdFS(rs.getInt("ID"));
                finalSalary.setPersonID(rs.getInt("PersonID"));
                finalSalary.setRolesID(rs.getInt("rolesID"));
                finalSalary.setReportCardID(rs.getInt("ReportCardID"));
                finalSalary.setTaxesID(rs.getInt("taxesID"));
                finalSalary.setFS(rs.getDouble("FinalSalary"));
                arrayList.add(finalSalary);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public void AddFSalary(FinalSalary finalSalary) {
        String insert;
        insert = "INSERT INTO finalsalary(PersonID, rolesID, ReportCardID, taxesID, FinalSalary) VALUES(?,?,?,?,?)";
        try {
            prST = getDbConnection().prepareStatement(insert);
            prST.setInt(1, finalSalary.getPersonID());
            prST.setInt(2, finalSalary.getRolesID());
            prST.setInt(3, finalSalary.getReportCardID());
            prST.setInt(4, finalSalary.getTaxesID());
            prST.setDouble(5, finalSalary.getFS());
            st=prST.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSalary(FinalSalary finalSalary) {
        String update;
        update = "UPDATE " + Const.FINALSALARY_TABLE + " SET " + Const.FINALSALARY_FINALSALARY + "=? WHERE " + Const.PERSONID + "=?";
        try {
            prST=getDbConnection().prepareStatement(update);
            prST.setDouble(1,finalSalary.getFS());
            prST.setInt(2,finalSalary.getIdFS());
            st=prST.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FinalSalary getFinalSalary(FinalSalary finalSalary) {
        String select;
        select = "SELECT FinalSalary FROM finalsalary WHERE ID=?";
        try {
            prST=getDbConnection().prepareStatement(select);
            prST.setInt(1,finalSalary.getPersonID());
            rs=prST.executeQuery();
            while(rs.next()){
                finalSalary.setFS(rs.getDouble("FinalSalary"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return finalSalary;
    }


}
