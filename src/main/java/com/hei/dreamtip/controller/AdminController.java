package com.hei.dreamtip.controller;



import com.hei.dreamtip.dto.AdminLoginDTO;
import com.hei.dreamtip.playloadresponse.AdminLoginMessage;

import com.hei.dreamtip.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(path = "/login")
    public ResponseEntity<AdminLoginMessage> loginAdmin(@RequestBody AdminLoginDTO adminLoginDTO) {
        AdminLoginMessage loginMessage = adminService.loginAdmin(adminLoginDTO);
        return ResponseEntity.ok(loginMessage);
    }
}
