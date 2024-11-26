package com.example.GCS.service.auth.implenebtation;

import com.example.GCS.dto.TmpUserHomeInfoDTO;
import com.example.GCS.dto.UserHomeInfoDTO;
import com.example.GCS.model.UserModel;
import com.example.GCS.repository.AuthRepository;
import com.example.GCS.service.auth.AuthService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;    // テスト対象クラス

    @Mock
    private AuthRepository authRepository;  // モック化する依存クラス
    private Dotenv dotenv;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this); //モックの初期化
        dotenv = Dotenv.configure().load(); // dotenv を初期化

    }

    @Test
    void testFindToken()throws Exception{

        //モックの動作定義
        String userId      = dotenv.get("TEST_SUB");
        /*
         * optionalとは
         * 値が存在する場合     : optional.of(value)
         * 値が存在しない場合   : optional.empty()
         */
        when(authRepository.findByUserId(userId))
                .thenReturn(Optional.of(new UserModel("123","TANAKA","xxx.yahoo.co.jp",
                        "12:30","12345678")));

        //テスト対象クラス
        AuthService result = new AuthService(authRepository);

        //テストの実行

        UserHomeInfoDTO userModel = result.VerifyTheUser(new TmpUserHomeInfoDTO());

        //結果の検証
        //assertEquals(new UserModel(), result.VerifyTheUser(userId));
        assertEquals(new UserHomeInfoDTO(), userModel);

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