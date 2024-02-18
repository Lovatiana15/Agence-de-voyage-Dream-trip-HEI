package com.hei.dreamtip.service.Impl;

import com.hei.dreamtip.service.LogoutService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;



import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LogoutServiceImpl implements LogoutService {

    @Autowired
    private HttpServletRequest request;  // Injection de la requête HTTP

    @Override
    public boolean logout() {
        // Récupération de la session associée à la requête
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Invalidation de la session
            session.invalidate();

            // Empêcher toute modification de la session après invalidation
            request.getSession(true);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean logout(String username) {
        // Pour l'instant, nous ne l'utilisons pas dans cette implémentation, donc nous la laissons vide.
        return false;
    }
}
