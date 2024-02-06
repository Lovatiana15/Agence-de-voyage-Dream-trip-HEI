package com.hei.dreamtip.service.Impl;



import com.hei.dreamtip.Entity.Admin;
import com.hei.dreamtip.dto.AdminLoginDTO;
import com.hei.dreamtip.playloadresponse.AdminLoginMessage;
import com.hei.dreamtip.repo.AdminRepo;

import com.hei.dreamtip.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AdminLoginMessage loginAdmin(AdminLoginDTO adminLoginDTO) {
        Optional<Admin> adminOptional = adminRepo.findByEmail(adminLoginDTO.getEmail());
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            if (admin.getKey().equals(adminLoginDTO.getKey())) {
                String password = adminLoginDTO.getPassword();
                if (passwordEncoder.matches(password, admin.getPassword())) {
                    return new AdminLoginMessage("Login Success", true);
                } else {
                    return new AdminLoginMessage("Password Not Match", false);
                }
            } else {
                return new AdminLoginMessage("Key Not Match", false);
            }
        } else {
            return new AdminLoginMessage("Email not exists", false);
        }
    }
}
