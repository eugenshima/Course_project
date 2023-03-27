package org.example.interfaces;

import org.example.model.Taxes;

import java.util.ArrayList;

public interface TaxesSQL {
    ArrayList<Taxes> getTaxes();
    public void insertTaxes(Taxes taxes);

    public void updateTaxes(Taxes taxes);
}
