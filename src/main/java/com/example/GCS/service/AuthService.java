package com.example.GCS.service;

import com.example.GCS.dto.UserHomeInfoDTO;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
public class AuthService {

    @Value("${GOOGLE_CLIENT_ID}") // Google Client ID を .env または application.properties に保存して読み込み
    private String clientId;

    public UserHomeInfoDTO authenticatingTheClientId(String token)throws GeneralSecurityException, IOException
    {
        //dbg用
        System.out.println("clientId =" + clientId);

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                .setAudience(Collections.singletonList(clientId))
                .build();

        // Payload オブジェクトを取得
        GoogleIdToken idToken = verifier.verify(token);
        UserHomeInfoDTO userInfo = new UserHomeInfoDTO();
        if(idToken != null)
        {
            GoogleIdToken.Payload payload = idToken.getPayload();
            userInfo.setUserName((String) payload.get("name")); // 名前を設定
            userInfo.setEmail(payload.getEmail()); // メールを設定
        }else {
            throw new IllegalArgumentException("Invalid ID token.");
        }

        return userInfo;
    }
}
