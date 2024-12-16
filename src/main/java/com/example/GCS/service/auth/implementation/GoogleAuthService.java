package com.example.GCS.service.auth.implementation;

import com.example.GCS.dto.TmpUserHomeInfoDTO;

import com.example.GCS.service.auth.TokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
//import com.google.api.client.json.jackson2.JacksonFactory;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Optional;

// SOLID_OCPの原則を適用してinterfaceに
@Service
public class GoogleAuthService implements TokenVerifier {

    @Value("${GOOGLE_CLIENT_ID}") // Google Client ID を .env または application.properties に保存して読み込み
    private String clientId;

    private final GoogleIdTokenVerifier googleIdTokenVerifier;

    // コンストラクタで GoogleIdTokenVerifier を注入
    public GoogleAuthService(GoogleIdTokenVerifier googleIdTokenVerifier){
        this.googleIdTokenVerifier = googleIdTokenVerifier;
    }

    /**
     * トークンを検証し、ユーザー情報を返す
     *
     * @param token Googleログインから受け取ったIDトークン
     * @return TmpUserHomeInfoDTO ユーザーの名前とメール情報
     */
    @Override
    public Optional<TmpUserHomeInfoDTO> GoogleVerifyToken(String token)throws GeneralSecurityException, IOException
    {
        //dbg用
        System.out.println("clientId =" + clientId);

        // Payload オブジェクトを取得
        GoogleIdToken idToken = googleIdTokenVerifier.verify(token);
        if(idToken == null)
        {
            return Optional.empty();    //空のoptional
        }

        GoogleIdToken.Payload payload = idToken.getPayload();
        TmpUserHomeInfoDTO tmpUserHomeInfoDTO = new TmpUserHomeInfoDTO();
        tmpUserHomeInfoDTO.setUserName((String) payload.get("name")); // 名前を設定
        tmpUserHomeInfoDTO.setEmail(payload.getEmail());              // メールを設定
        tmpUserHomeInfoDTO.setUserId(payload.getSubject());           // JWTから一意のsub
//            System.out.println("--------------------------");
//            System.out.println("userInfo.getUserId() = "+userInfo.getUserId());

        return Optional.of(tmpUserHomeInfoDTO);
    }
}
