package com.example.GCS.service;

import com.example.GCS.dto.UserHomeInfoDTO;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class AuthService {

    @Value("${GOOGLE_CLIENT_ID}") // Google Client ID を .env または application.properties に保存して読み込み
    private String clientId;

    public UserHomeInfoDTO authenticatingTheClientId(String token)throws GeneralSecurityException, IOException
    {
        //dbg用
        System.out.println("clientId =" + clientId);

        UserHomeInfoDTO userInfo = new UserHomeInfoDTO();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                .setAudience(Collections.singletonList(clientId))
                .build();

        GoogleIdToken idToken = verifier.verify(token);

        return userInfo;
    }
}
