package com.example.harshit.apiuse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by harshit on 13/10/17.
 */

public class ResultData {



    @SerializedName("auth_token")
    @Expose
    private String auth_token;

    @SerializedName("email")
    @Expose
    private String  email ;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("isvalid")
    @Expose
    private boolean isvalid;


    public boolean isvalid() {
        return isvalid;
    }

    public void setIsvalid(boolean isvalid) {
        this.isvalid = isvalid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuth_token() {
        return auth_token;
    }

    public String getEmail() {
        return email;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
