package com.hei.dreamtip.dto;

import java.time.LocalDateTime;

public class UserLoginHistoryDTO {

    private Long id;
    private LocalDateTime loginTime;

    // Constructeur
    public UserLoginHistoryDTO(Long id, LocalDateTime loginTime) {
        this.id = id;
        this.loginTime = loginTime;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }
}
