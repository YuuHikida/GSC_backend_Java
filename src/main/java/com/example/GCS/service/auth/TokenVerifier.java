package com.example.GCS.service.auth;

import com.example.GCS.dto.TmpUserHomeInfoDTO;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Optional;

// authService interface
public interface TokenVerifier {
    // google Auth用
    Optional<TmpUserHomeInfoDTO> GoogleVerifyToken(String token) throws GeneralSecurityException, IOException;
    // いつかgithub アカウントとかでログイン出来たらいいなぁ...↓
}
