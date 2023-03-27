package org.example.interfaces;

import org.example.model.FinalModel;

import java.util.ArrayList;

public interface FinalModelSQL {
    ArrayList<FinalModel> getSALARY();

    FinalModel saveSalaryToFile(FinalModel finalModel);

    ArrayList<FinalModel> SearchByID(FinalModel finalModel);
}
