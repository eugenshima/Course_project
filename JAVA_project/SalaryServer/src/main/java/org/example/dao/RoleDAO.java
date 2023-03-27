package org.example.dao;

import org.example.interfaces.RoleSQL;
import org.example.model.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO extends ConnectionFactory implements RoleSQL {
    PreparedStatement prST = null;

    ResultSet rs;

    int st; //status

    @Override
    public Role getRole(Role role) {
        String select;
        select = "SELECT * FROM roles WHERE PersonID=?";
        try {
            prST = getDbConnection().prepareStatement(select);
            prST.setInt(1, role.getPersonID());
            rs=prST.executeQuery();
            while (rs.next()) {
                role.setrID(rs.getInt("RID"));
                role.setURole(rs.getString("URole"));
                role.setPersonID(rs.getInt("PersonID"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return role;
    }

    @Override
    public void putRole(Role role) {
        String insert;
        insert = "INSERT INTO roles(URole, PersonID) VALUES(?,?)";
        try {
            prST = getDbConnection().prepareStatement(insert);
            prST.setString(1, role.getURole());
            prST.setInt(2,role.getPersonID());
            st=prST.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int CountCol(Role role) {
        String select;
        int quantity = -1;
        select = "SELECT  COUNT(*) AS URole FROM roles WHERE Urole=?";
        try {
            prST = getDbConnection().prepareStatement(select);
            prST.setString(1, role.getURole());
            rs=prST.executeQuery();

            if(rs.next()) {
                String temp = rs.getString("URole"); // "quantity" - псевдоним из запроса
                quantity = Integer.parseInt(temp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return quantity;
    }

    @Override
    public void updateRole(Role role) {
        String update;
        update = "UPDATE roles SET URole=? WHERE PersonID=?";
        try {
            prST = getDbConnection().prepareStatement(update);
            prST.setString(1, role.getURole());
            prST.setInt(2, role.getPersonID());
            st=prST.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
