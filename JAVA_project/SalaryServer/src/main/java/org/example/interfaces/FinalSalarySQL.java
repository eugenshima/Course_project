package org.example.interfaces;

import org.example.model.FinalSalary;
import org.example.model.Person;
import org.example.model.Staffing;

import java.util.ArrayList;

public interface FinalSalarySQL {
    public ArrayList<FinalSalary> GetSalaryList();

    void AddFSalary(FinalSalary finalSalary);

    void updateSalary(FinalSalary finalSalary);

    FinalSalary getFinalSalary(FinalSalary finalSalary);



}
