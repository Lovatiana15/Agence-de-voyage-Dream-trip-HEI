package com.hei.dreamtip.repo;

import com.hei.dreamtip.Entity.User;
import com.hei.dreamtip.Entity.UserLoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginHistoryRepository extends JpaRepository<UserLoginHistory, Long> {
    List<UserLoginHistory> findByUserOrderByLoginTimeDesc(User user);
    // Ajoutez des méthodes personnalisées si nécessaire
}
