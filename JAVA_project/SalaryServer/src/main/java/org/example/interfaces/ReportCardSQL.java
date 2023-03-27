package org.example.interfaces;

import org.example.model.ReportCard;
import org.example.model.Staffing;

import java.util.ArrayList;

public interface ReportCardSQL {
    public ArrayList<ReportCard> GetReportCardList();
    public void AddReportCardInfo(ReportCard reportCard);

    void updateDaysWorked(ReportCard reportCard);

    ReportCard getDaysWorked(ReportCard reportCard);
}
