package com.hei.dreamtip.controller;

import com.hei.dreamtip.dto.LoginDTO;
import com.hei.dreamtip.dto.UserDTO;
import com.hei.dreamtip.playloadresponse.LoginMessage;
import com.hei.dreamtip.service.AdminService;
import com.hei.dreamtip.service.Impl.AdminServiceImpl;
import com.hei.dreamtip.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/user")



public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @Autowired // Injection de dépendance pour AdminServiceImpl
    private AdminServiceImpl adminServiceImpl;

    @PostMapping (path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO) {
        String id = userService.addUser(userDTO);
        return id;
    }
    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        // Si la clé est fournie et correspond à celle d'un administrateur, utilisez le service d'administration pour gérer la connexion
        if (loginDTO.getKey() != null && !loginDTO.getKey().isEmpty()) {

            if (adminServiceImpl.isAdminKey(loginDTO.getKey())) {
                LoginMessage adminLoginMessage = adminService.loginAdmin(loginDTO);
                if (adminLoginMessage != null) {
                    return ResponseEntity.ok(adminLoginMessage);
                }
            }
        }

        // Sinon, procédez avec la logique de connexion normale pour les utilisateurs
        LoginMessage userLoginMessage = userService.loginUser(loginDTO);
        return ResponseEntity.ok(userLoginMessage);
    }
    private boolean isAdminKey(String key) {
        return "super_secret_admin_key".equals(key);
    }

}

