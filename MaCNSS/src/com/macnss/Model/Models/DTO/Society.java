package com.macnss.Model.Models.DTO;

public class Society {
    private  int society_id;
    private  String society_name;
    private  String society_email;
    private  String society_paasword;


    public Society(int society_id, String society_name, String society_email, String society_paasword) {
        this.society_id = society_id;
        this.society_name = society_name;
        this.society_email = society_email;
        this.society_paasword = society_paasword;
    }

    public Society(Society society) {
        this.society_id = society.society_id;
        this.society_name = society.society_name;
        this.society_email = society.society_email;
        this.society_paasword = society.society_paasword;
    }



    public int getSociety_id() {
        return society_id;
    }

    public void setSociety_id(int society_id) {
        this.society_id = society_id;
    }

    public String getSociety_name() {
        return society_name;
    }

    public void setSociety_name(String society_name) {
        this.society_name = society_name;
    }

    public String getSociety_email() {
        return society_email;
    }

    public void setSociety_email(String society_email) {
        society_email = society_email;
    }

    public String getSociety_paasword() {
        return society_paasword;
    }

    public void setSociety_paasword(String society_paasword) {
        society_paasword = society_paasword;
    }
}
