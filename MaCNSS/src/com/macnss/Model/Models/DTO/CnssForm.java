package com.macnss.Model.Models.DTO;

public class CnssForm {
    private int id;
    private float totalPrice;
    private int attachmentsNumber;

    @Override
    public String toString() {
        return "CnssForm{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", attachmentsNumber=" + attachmentsNumber +
                ", status='" + status + '\'' +
                ", patientNumber=" + patientNumber +
                '}';
    }

    private String status;

    private int patientNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getAttachmentsNumber() {
        return attachmentsNumber;
    }

    public void setAttachmentsNumber(int attachmentsNumber) {
        this.attachmentsNumber = attachmentsNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }
}
