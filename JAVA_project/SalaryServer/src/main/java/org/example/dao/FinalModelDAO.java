package org.example.dao;

import org.example.interfaces.FinalModelSQL;
import org.example.model.FinalModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FinalModelDAO extends ConnectionFactory implements FinalModelSQL {
    PreparedStatement prST = null;

    ResultSet rs = null;

    int st;

    @Override
    public ArrayList<FinalModel> getSALARY() {
        ArrayList<FinalModel> arrayList = new ArrayList<>();
        String select;
        select = "SELECT finalsalary.ID, person.UserFName, person.UserLName, roles.URole, FinalSalary, taxes.UserTaxes, reportcard.DaysWorked FROM finalsalary \n" +
                "JOIN person ON person.ID=PersonID\n" +
                "JOIN roles ON roles.RID=rolesID\n" +
                "JOIN taxes ON taxes.ID=taxesID\n" +
                "JOIN reportcard ON reportcard.RCID=ReportCardID;";
        try {
            prST = getDbConnection().prepareStatement(select);
            rs=prST.executeQuery();
            while (rs.next()) {
                FinalModel finalModel = new FinalModel();
                finalModel.setPersonID(rs.getInt("finalsalary.ID"));
                finalModel.setName(rs.getString("person.UserFName"));
                finalModel.setSurname(rs.getString("person.UserLName"));
                finalModel.setRole(rs.getString("roles.URole"));
                finalModel.setSalary(rs.getInt("FinalSalary"));
                finalModel.setTaxes(rs.getInt("taxes.UserTaxes"));
                finalModel.setDaysWorked(rs.getInt("reportcard.DaysWorked"));
                arrayList.add(finalModel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public FinalModel saveSalaryToFile(FinalModel finalModel) {
        String select;
        select = "SELECT finalsalary.ID, person.UserFName, person.UserLName, roles.URole, FinalSalary, taxes.UserTaxes, reportcard.DaysWorked FROM finalsalary WHERE finalsalary.ID=? \n" +
                "JOIN person ON person.ID=PersonID\n" +
                "JOIN roles ON roles.RID=rolesID\n" +
                "JOIN taxes ON taxes.ID=taxesID\n" +
                "JOIN reportcard ON reportcard.RCID=ReportCardID;";
        try {
            prST = getDbConnection().prepareStatement(select);
            prST.setInt(1, finalModel.getPersonID());
            rs=prST.executeQuery();
            while (rs.next()) {
                finalModel.setPersonID(rs.getInt("finalsalary.ID"));
                finalModel.setName(rs.getString("person.UserFName"));
                finalModel.setSurname(rs.getString("person.UserLName"));
                finalModel.setRole(rs.getString("roles.URole"));
                finalModel.setSalary(rs.getInt("FinalSalary"));
                finalModel.setTaxes(rs.getInt("taxes.UserTaxes"));
                finalModel.setDaysWorked(rs.getInt("reportcard.DaysWorked"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return finalModel;
    }

    @Override
    public ArrayList<FinalModel> SearchByID(FinalModel finalModel) {
        ArrayList<FinalModel> arrayList = new ArrayList<>();
        String select;
        select = "SELECT finalsalary.ID, person.UserFName, person.UserLName, roles.URole, FinalSalary, taxes.UserTaxes, reportcard.DaysWorked FROM finalsalary " +
                " JOIN person ON person.ID=PersonID\n" +
                " JOIN roles ON roles.RID=rolesID\n" +
                " JOIN taxes ON taxes.ID=taxesID\n" +
                " JOIN reportcard ON reportcard.RCID=ReportCardID WHERE finalsalary.ID=?;";
        try {
            prST = getDbConnection().prepareStatement(select);
            prST.setInt(1, finalModel.getPersonID());
            rs=prST.executeQuery();
            while (rs.next()) {
                finalModel.setPersonID(rs.getInt("finalsalary.ID"));
                finalModel.setName(rs.getString("person.UserFName"));
                finalModel.setSurname(rs.getString("person.UserLName"));
                finalModel.setRole(rs.getString("roles.URole"));
                finalModel.setSalary(rs.getInt("FinalSalary"));
                finalModel.setTaxes(rs.getInt("taxes.UserTaxes"));
                finalModel.setDaysWorked(rs.getInt("reportcard.DaysWorked"));
                arrayList.add(finalModel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

}
