package com.hei.dreamtip.service.Impl;

import com.hei.dreamtip.Entity.User;
import com.hei.dreamtip.Entity.UserLoginHistory;
import com.hei.dreamtip.dto.UserLoginHistoryDTO;

import com.hei.dreamtip.error.UserNotFoundException;
import com.hei.dreamtip.repo.UserLoginHistoryRepository;
import com.hei.dreamtip.repo.UserRepo;
import com.hei.dreamtip.dto.UserInfoDTO;
import com.hei.dreamtip.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserLoginHistoryRepository userLoginHistoryRepository;

    @Override
    public UserInfoDTO getUserInfo(String username) {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User with username " + username + " not found");
        }
        return new UserInfoDTO(user.getUsername(), user.getUserLastName(), user.getEmail(), user.getPhoneNumber(), user.getAddress());
    }

    @Override
    public List<UserLoginHistoryDTO> getUserLoginHistory(String username) {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User with username " + username + " not found");
        }
        List<UserLoginHistory> loginHistoryList = userLoginHistoryRepository.findByUserOrderByLoginTimeDesc(user);
        return loginHistoryList.stream()
                .map(history -> new UserLoginHistoryDTO(history.getId(), history.getLoginTime()))
                .collect(Collectors.toList());
    }
}

