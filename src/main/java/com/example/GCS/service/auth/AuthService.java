package com.example.GCS.service.auth;

import com.example.GCS.dto.UserHomeInfoDTO;
import com.example.GCS.exception.InvalidTokenException;
import com.example.GCS.repository.AuthRepository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/*
 * 概要:JWT検証およびその周りの操作
 */
@Service
public class AuthService {

     private final AuthRepository authRepository;

     public AuthService(AuthRepository authRepository)
     {
         this.authRepository= authRepository;
     }

    /**
     * 概要:トークンを検証し、JWTに格納されているユーザー情報を返す
     *
     * @param token Googleログインから受け取ったIDトークン
     * @return FirebaseToken ... トークンに含まれる情報を返す
     */
    public FirebaseToken verifyJWT(String token)
    {
        //引数チェック
        if(token == null || StringUtils.isEmpty(token) || !token.startsWith("Bearer "))
        {
            throw new InvalidTokenException("Token is null or empty");
        }
        //トークンを抽出
        String trimToken = token.replace("Bearer ","").trim();
        //ここにデバックプリント文クラスとか作りたいなぁ

        //JWTの検証
        try
        {
            return FirebaseAuth.getInstance().verifyIdToken(token);
        } catch (Exception e) {
            throw new IllegalArgumentException("無効なトークンです: " + e.getMessage());
        }
//        UserHomeInfoDTO userHomeInfoDTO = new UserHomeInfoDTO();
//        userHomeInfoDTO.setUserName("TANAKA");

//        return new UserHomeInfoDTO();
    }

}
