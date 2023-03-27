package org.example.interfaces;

import org.example.model.Role;

public interface RoleSQL {
    Role getRole(Role role);

    void putRole(Role role);

    int CountCol(Role role);

    void updateRole(Role role);
}
