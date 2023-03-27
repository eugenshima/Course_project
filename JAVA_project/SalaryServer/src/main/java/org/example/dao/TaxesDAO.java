package org.example.dao;

import org.example.interfaces.TaxesSQL;
import org.example.model.Taxes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaxesDAO extends ConnectionFactory implements TaxesSQL {
    PreparedStatement prST = null;

    ResultSet rs;

    int st; //status

    @Override
    public ArrayList<Taxes> getTaxes() {
        ArrayList<Taxes> arrayList = new ArrayList<>();

        return arrayList;
    }

    @Override
    public void insertTaxes(Taxes taxes) {
        String insert;
        insert = "INSERT INTO " + Const.TAXES_TABLE + "(" + Const.PERSONID + "," + Const.USER_TAXES + ") VALUES(?,?)";
        try {
            prST = getDbConnection().prepareStatement(insert);
            prST.setInt(1, taxes.getPersonID());
            prST.setInt(2, taxes.getUserTaxes());
            st=prST.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTaxes(Taxes taxes) {
        String update;
        update = "UPDATE " + Const.TAXES_TABLE + " SET " + Const.USER_TAXES + "=? WHERE " + Const.PERSONID + "=?";
        try {
            prST = getDbConnection().prepareStatement(update);
            prST.setInt(1, taxes.getUserTaxes());
            prST.setInt(2, taxes.getPersonID());
            prST.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
