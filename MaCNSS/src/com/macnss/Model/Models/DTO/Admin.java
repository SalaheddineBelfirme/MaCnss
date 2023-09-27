package com.macnss.Model.Models.DTO;

public class Admin extends User {
    private int adminId;

    public Admin(int adminId,String email, String password) {
        this.adminId = adminId;
        this.email=email;
        this.password=password;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}
