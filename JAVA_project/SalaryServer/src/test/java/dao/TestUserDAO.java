package dao;

import org.example.dao.RoleDAO;
import org.example.dao.UserDAO;
import org.example.interfaces.RoleSQL;
import org.example.interfaces.UserSQL;
import org.example.model.Role;
import org.example.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUserDAO {
    @Test
    public void TestGetUser() {
        User user = new User();
        Role role = new Role();
        UserSQL dao = new UserDAO();
        RoleSQL rdao = new RoleDAO();
        user.setUserLogin("admin");
        user.setUserPassword("admin");
        user = dao.getUser(user);
        role.setPersonID(user.getPersonID());
        role = rdao.getRole(role);
        Assertions.assertTrue(role.getURole().equals("Admin"));
    }
}
