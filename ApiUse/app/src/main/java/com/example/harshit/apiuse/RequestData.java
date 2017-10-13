package com.example.harshit.apiuse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by harshit on 13/10/17.
 */

public class RequestData {



    private String email ;




    private String password;




    private String phone_no;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

}

