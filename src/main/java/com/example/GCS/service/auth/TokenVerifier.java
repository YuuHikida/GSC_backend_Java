package com.example.GCS.service.auth;

import com.example.GCS.dto.UserHomeInfoDTO;

import java.io.IOException;
import java.security.GeneralSecurityException;

// authService interface
public interface TokenVerifier {
    // google Auth用
    UserHomeInfoDTO verifyToken (String token) throws GeneralSecurityException, IOException;
    // いつかgithub アカウントとかでログイン出来たらいいなぁ...↓
}
