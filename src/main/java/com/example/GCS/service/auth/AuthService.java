package com.example.GCS.service.auth;

import com.example.GCS.dto.TmpUserHomeInfoDTO;
import com.example.GCS.dto.UserHomeInfoDTO;
import com.example.GCS.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

     private final AuthRepository authRepository;

     public AuthService(AuthRepository authRepository)
     {
         this.authRepository= authRepository;
     }


    // 概要:フロントJWT検証後のメアドとDBの値が一致するか確認する
    public UserHomeInfoDTO VerifyTheUser(TmpUserHomeInfoDTO tmpUserHomeInfoDTO){

        return new UserHomeInfoDTO();
    }

}
