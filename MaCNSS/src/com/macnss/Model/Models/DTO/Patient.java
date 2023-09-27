package com.macnss.Model.Models.DTO;

import java.util.Date;

public class Patient {
    private int registrationNumber;
    private String fullName;
    private String cin;

    @Override
    public String toString() {
        return "registration number: " + registrationNumber + "\n" +
                "full name: " + fullName + "\n" +
                "cin: " + cin + "\n" +
                "address: " + address;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    private String address;
    private Date birthDate;
}
