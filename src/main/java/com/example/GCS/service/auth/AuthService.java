package com.example.GCS.service.auth;

import com.example.GCS.dto.UserHomeInfoDTO;
import com.example.GCS.exception.InvalidTokenException;
import com.example.GCS.repository.AuthRepository;

import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/*
 * 概要:フロントから受け取ったJWTを検証し異常がないかを返す
 */
@Service
public class AuthService {

     private final AuthRepository authRepository;

     public AuthService(AuthRepository authRepository)
     {
         this.authRepository= authRepository;
     }

    public UserHomeInfoDTO verifyJWT(String token)
    {
        //引数チェック
        if(token == null || StringUtils.isEmpty(token) || !token.startsWith("Bearer "))
        {
            throw new InvalidTokenException("Token is null or empty");
        }
        //トークンを抽出
        String trimToken = token.replace("Bearer ","").trim();
        //ここにデバックプリント文クラスとか作りたいなぁ

//        UserHomeInfoDTO userHomeInfoDTO = new UserHomeInfoDTO();
//        userHomeInfoDTO.setUserName("TANAKA");

        return new UserHomeInfoDTO();
    }

}
