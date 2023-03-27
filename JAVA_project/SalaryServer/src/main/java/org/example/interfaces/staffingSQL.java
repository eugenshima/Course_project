package org.example.interfaces;

import org.example.model.Staffing;

import java.util.ArrayList;

public interface staffingSQL {
    public ArrayList<Staffing> GetStaffingList();

    public void AddStaff(Staffing staffing);

    public void updateStaff(Staffing staffing);

    public ArrayList<Staffing> searchStaff(Staffing staffing);

    Staffing getCasing(Staffing staffing);
}
