package com.macnss.Model.Models.DTO;

public class Agent extends User {
    private int agentId;


    public Agent(int agentId,String email, String password) {
        this.agentId = agentId;
        this.email=email;
        this.password=password;
    }
    public Agent(Agent A) {
        this.agentId = A.agentId;
        this.email=A.getEmail();
        this.password=A.getPassword();
    }

    public  Agent(){};
    public int getAdminId() {
        return agentId;
    }

    public void setAdminId(int adminId) {
        this.agentId = adminId;
    }
}
