package com.example.GCS.service.auth.implenebtation;

import com.example.GCS.dto.TmpUserHomeInfoDTO;
import com.example.GCS.dto.UserHomeInfoDTO;

import com.example.GCS.service.auth.TokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
//import com.google.api.client.json.jackson2.JacksonFactory;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

// SOLID_OCPの原則を適用してinterfaceに
@Service
public class GoogleAuthService implements TokenVerifier {

    @Value("${GOOGLE_CLIENT_ID}") // Google Client ID を .env または application.properties に保存して読み込み
    private String clientId;
    /**
     * トークンを検証し、ユーザー情報を返す
     *
     * @param token Googleログインから受け取ったIDトークン
     * @return UserHomeInfoDTO ユーザーの名前とメール情報
     * @throws GeneralSecurityException セキュリティ例外
     * @throws IOException 入出力例外
     */
    @Override
    public TmpUserHomeInfoDTO verifyToken(String token)throws GeneralSecurityException, IOException
    {
        //dbg用
        System.out.println("clientId =" + clientId);

        GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), jsonFactory)
                .setAudience(Collections.singletonList(clientId))
                .build();

        // Payload オブジェクトを取得
        GoogleIdToken idToken = verifier.verify(token);
        TmpUserHomeInfoDTO userInfo = new TmpUserHomeInfoDTO();
        if(idToken != null)
        {
            GoogleIdToken.Payload payload = idToken.getPayload();
            userInfo.setUserName((String) payload.get("name")); // 名前を設定
            userInfo.setEmail(payload.getEmail());              // メールを設定
            userInfo.setUserId(payload.getSubject());           // JWTから一意のsub
            System.out.println("--------------------------");
            System.out.println("userInfo.getUserId() = "+userInfo.getUserId());
        }else {
            throw new IllegalArgumentException("Invalid ID token.");
        }

        return userInfo;
    }
}
