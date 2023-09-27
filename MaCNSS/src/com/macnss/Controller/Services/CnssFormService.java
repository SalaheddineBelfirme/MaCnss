package com.macnss.Controller.Services;

import com.macnss.Controller.MedicineController;
import com.macnss.Model.Models.DoctorType;
import com.macnss.Model.Models.MedicalSummary;

import java.util.ArrayList;
import java.util.Map;

public class CnssFormService {
    public static float calcRefundAmount(ArrayList<String> medicineCodes, MedicalSummary[] documents) {
        float refundAmount = 0;
        // First phase: calculating total visits reimbursement => 80% for Specialist visits, 50% for Generalist visits
        for (MedicalSummary document : documents) {
            if(document.getDoctorType() == DoctorType.SPECIALIST)
                refundAmount += document.getPrice() * 0.8;
            else
                refundAmount += document.getPrice() * 0.5;
        }
        // Second phase: calculating total medicines reimbursement via calcMedicineRefund()
        refundAmount += calcMedicineRefund(medicineCodes);
        return refundAmount;
    }

    private static float calcMedicineRefund(ArrayList<String> codes) {
        float refundAmount = 0;
        // Fetching all medicines from database
        Map<String, Float> reimbursableMedicines = MedicineController.get();
         // Loop throw medicines codes
        for (String key : codes) {
            // Checking if database medicines contain current medicine
            if(reimbursableMedicines.containsKey(key)) {
                // Adding reimbursable price to refundAmount variable
                refundAmount += reimbursableMedicines.get(key);
            }
        }
        return refundAmount;
    }
}
