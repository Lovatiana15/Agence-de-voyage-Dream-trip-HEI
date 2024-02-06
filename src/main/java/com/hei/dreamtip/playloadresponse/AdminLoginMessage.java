package com.hei.dreamtip.playloadresponse;



public class AdminLoginMessage {
    private String message;
    private Boolean status;

    public AdminLoginMessage(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
// Constructeur, getters et setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
