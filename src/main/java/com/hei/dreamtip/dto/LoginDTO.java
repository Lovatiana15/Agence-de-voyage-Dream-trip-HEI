package com.hei.dreamtip.dto;

public class LoginDTO {
    private String email;
    private String password;
    private String key;
    public LoginDTO() {
    }


    public LoginDTO(String email, String password, String key) {
        this.email = email;
        this.password = password;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

}

