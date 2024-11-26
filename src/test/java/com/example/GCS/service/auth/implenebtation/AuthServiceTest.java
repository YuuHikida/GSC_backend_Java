package com.example.GCS.service.auth.implenebtation;

import com.example.GCS.service.auth.AuthService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(AuthService.class)
public class AuthServiceTest {

    @Test
    public void testGetUser()throws Exception{

    }
//    private GoogleAuthService googleAuthService;
//
//    @Mock
//    private GoogleIdTokenVerifier googleIdTokenVerifier;
//
//    @Mock
//    private GoogleIdToken googleIdToken;
//
//    @Mock
//    private GoogleIdToken.Payload payload; // GoogleIdToken.Payloadをモック

//    @BeforeEach
//    void setup(){
//        MockitoAnnotations.openMocks(this); //mockitoのモックを初期化
//        googleAuthService = new GoogleAuthService();
//        //googleAuthService.clientId=
//    }

}