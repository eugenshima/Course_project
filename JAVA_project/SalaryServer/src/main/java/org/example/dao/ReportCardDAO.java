package org.example.dao;

import org.example.interfaces.ReportCardSQL;
import org.example.model.ReportCard;
import org.example.model.Staffing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportCardDAO extends ConnectionFactory implements ReportCardSQL {
    PreparedStatement prST = null;

    ResultSet rs = null;

    int st;
    @Override
    public ArrayList<ReportCard> GetReportCardList() {
        ArrayList<ReportCard> arrayList = new ArrayList<>();
        String select;
        select = "SELECT * FROM " + Const.REPORT_CARD_TABLE;
        try {
            prST = getDbConnection().prepareStatement(select);
            rs=prST.executeQuery();
            while(rs.next()) {
                ReportCard reportCard = new ReportCard();
                reportCard.setRCID(rs.getInt("RCID"));
                reportCard.setPersonID(rs.getInt("PersonID"));
                reportCard.setDaysWorked(rs.getInt("DaysWorked"));
                reportCard.setName(rs.getString("Name"));
                reportCard.setSurname(rs.getString("Surname"));
                arrayList.add(reportCard);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public void AddReportCardInfo(ReportCard reportCard) {
        String insert;
        insert = "INSERT INTO " + Const.REPORT_CARD_TABLE + "(PersonID, DaysWorked, Name, Surname) VALUES(?,?,?,?)";
        try {
            prST = getDbConnection().prepareStatement(insert);
            prST.setInt(1, reportCard.getPersonID());
            prST.setInt(2, reportCard.getDaysWorked());
            prST.setString(3, reportCard.getName());
            prST.setString(4, reportCard.getSurname());
            st=prST.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateDaysWorked(ReportCard reportCard) {

    }

    @Override
    public ReportCard getDaysWorked(ReportCard reportCard) {
        String select;
        select = "SELECT DaysWorked FROM reportcard WHERE RCID=?";
        try {
            prST=getDbConnection().prepareStatement(select);
            prST.setInt(1,reportCard.getRCID());
            rs=prST.executeQuery();
            while(rs.next()){
                reportCard.setDaysWorked(rs.getInt("DaysWorked"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return reportCard;
    }
}
