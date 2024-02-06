package com.hei.dreamtip.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "user_last_name", length = 50)
    private String userLastName;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    public User(int userId, String username, String userLastName, String email, String password, String phoneNumber) {
    }

    public User(String username, String userLastName, String email, String password, String phoneNumber) {
        this.username = username;
        this.userLastName = userLastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User() {

    }

    // Getters and setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
