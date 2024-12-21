package com.example.GCS.service.auth;

import com.example.GCS.dto.TmpUserHomeInfoDTO;
import com.example.GCS.dto.UserHomeInfoDTO;
import com.example.GCS.model.UserModel;
import com.example.GCS.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

     private final AuthRepository authRepository;

     public AuthService(AuthRepository authRepository)
     {
         this.authRepository= authRepository;
     }

    public UserHomeInfoDTO verifyJWT(String token)
    {

        return new UserHomeInfoDTO();
    }

}
