package com.hei.dreamtip.controller;

import com.hei.dreamtip.dto.LoginDTO;
import com.hei.dreamtip.dto.UserDTO;
import com.hei.dreamtip.dto.UserInfoDTO;
import com.hei.dreamtip.dto.UserLoginHistoryDTO;

import com.hei.dreamtip.error.UserNotFoundException;
import com.hei.dreamtip.playloadresponse.LoginMessage;
import com.hei.dreamtip.service.AdminService;
import com.hei.dreamtip.service.LogoutService;
import com.hei.dreamtip.service.UserInfoService;
import com.hei.dreamtip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private LogoutService logoutService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO) {
        String id = userService.addUser(userDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        if (loginDTO.getKey() != null && !loginDTO.getKey().isEmpty()) {
            if (isAdminKey(loginDTO.getKey())) {
                LoginMessage adminLoginMessage = adminService.loginAdmin(loginDTO);
                if (adminLoginMessage != null) {
                    return ResponseEntity.ok(adminLoginMessage);
                }
            }
        }

        LoginMessage userLoginMessage = userService.loginUser(loginDTO);
        return ResponseEntity.ok(userLoginMessage);
    }

    @GetMapping(path = "/info")
    public ResponseEntity<?> getUserInfo(@RequestParam(required = false) String username) {
        if (username == null || username.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username parameter is missing or empty");
        }

        try {
            UserInfoDTO userInfoDTO = userInfoService.getUserInfo(username);
            return ResponseEntity.ok(userInfoDTO);
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping(path = "/login-history")
    public ResponseEntity<?> getUserLoginHistory(@RequestParam(required = false) String username) {
        if (username == null || username.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username parameter is missing or empty");
        }

        try {
            List<UserLoginHistoryDTO> loginHistory = userInfoService.getUserLoginHistory(username);
            return ResponseEntity.ok(loginHistory);
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PostMapping(path = "/logout")
    public ResponseEntity<String> logoutUser(@RequestParam String username) {
        boolean success = logoutService.logout(username);
        if (success) {
            return ResponseEntity.ok("User logged out successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to log out user");
        }
    }

    private boolean isAdminKey(String key) {
        return "super_secret_admin_key".equals(key);
    }
}
