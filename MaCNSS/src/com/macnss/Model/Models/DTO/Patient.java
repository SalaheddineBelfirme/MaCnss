package com.macnss.Model.Models.DTO;

import java.util.Date;

public class Patient {
    private int registrationNumber;
    private String fullName;
    private String cin;
    private  int society_id ;
    private int number_days;
    private  float salery;
    private  boolean stil_work;
    private  boolean is_benefit;
    public int getSociety_id() {
        return society_id;
    }

    public Patient(int registrationNumber, String fullName, String cin, int society_id, int number_days, float salery, boolean stil_work, boolean is_benefit, String address, Date birthDate) {
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.cin = cin;
        this.society_id = society_id;
        this.number_days = number_days;
        this.salery = salery;
        this.stil_work = stil_work;
        this.is_benefit = is_benefit;
        this.address = address;
        this.birthDate = birthDate;
    }

    public Patient() {
    }

    public void setSociety_id(int society_id) {
        this.society_id = society_id;
    }

    public int getNumber_days() {
        return number_days;
    }

    public void setNumber_days(int number_days) {
        this.number_days = number_days;
    }

    public float getSalery() {
        return salery;
    }

    public void setSalery(float salery) {
        this.salery = salery;
    }

    public boolean isStil_work() {
        return stil_work;
    }

    public void setStil_work(boolean stil_work) {
        this.stil_work = stil_work;
    }

    public boolean isIs_benefit() {
        return is_benefit;
    }

    public void setIs_benefit(boolean is_benefit) {
        this.is_benefit = is_benefit;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "registrationNumber=" + registrationNumber +
                ", fullName='" + fullName + '\'' +
                ", cin='" + cin + '\'' +
                ", society_id=" + society_id +
                ", number_days=" + number_days +
                ", salery=" + salery +
                ", stil_work=" + stil_work +
                ", is_benefit=" + is_benefit +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                '}';
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
