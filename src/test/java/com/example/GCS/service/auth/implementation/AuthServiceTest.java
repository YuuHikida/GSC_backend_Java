package com.example.GCS.service.auth.implementation;

import com.example.GCS.dto.TmpUserHomeInfoDTO;
import com.example.GCS.dto.UserHomeInfoDTO;
import com.example.GCS.exception.InvalidTokenException;
import com.example.GCS.model.UserModel;
import com.example.GCS.repository.AuthRepository;
import com.example.GCS.service.auth.AuthService;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;


import java.io.FileInputStream;
import java.util.Optional;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AuthServiceTest {

    @Mock
    private AuthRepository authRepository;

    @Mock
    private FirebaseAuth firebaseAuth;

    @InjectMocks
    private AuthService authService;

    private String serviceAccountPath;
    private String testJWT;
    private String trimmedTestJWT;
    private UserModel userModel;

    @BeforeEach
    void setup()throws Exception {
        Dotenv dotenv = Dotenv.load();
        serviceAccountPath=dotenv.get("SERVICE_ACCOUNT_PATH");
        //FirebaseAppの初期化
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(serviceAccountPath)))
                        .build();
        if(FirebaseApp.getApps().isEmpty()){
            FirebaseApp.initializeApp(options);
        }
        // Mockitoのモック初期化
        MockitoAnnotations.openMocks(this);
        // ダミーのJWTトークンを生成（本来はJwtUtilなどを使う）
        testJWT        = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0VXNlciIsImlhdCI6MTY5NzU3MTQwMCwiZXhwIjoxNjk3NTc1MDAwfQ.somemocksignature";
        trimmedTestJWT = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0VXNlciIsImlhdCI6MTY5NzU3MTQwMCwiZXhwIjoxNjk3NTc1MDAwfQ.somemocksignature";
//        userModel = new UserModel("987","TANAKA","sample@yahoo.co.jp","19:19","123");
        FirebaseToken firebaseToken;
    }


    //正常系1(引数にjwtを渡し、正常にFireBaseTokenを返す)
    @Test
    void testNormalReturnJWT() throws FirebaseAuthException {
        //事前準備
        FirebaseToken mockFirebaseToken = mock(FirebaseToken.class);
        //Firebaseの認証結果として返されるFirebaseTokenをモック化
        when(firebaseAuth.verifyIdToken(trimmedTestJWT)).thenReturn(mockFirebaseToken);

        //実行
        FirebaseToken result = authService.verifyJWT(testJWT);
        assertEquals(mockFirebaseToken, result);


    }
/*// 仕様変更により一旦off
    //正常系
    @Test
    void testVerifyJWT(){
        //モックの設定
        String userId = "123";
        //when()の中には実際に呼び出すわけではなく、テストコードの中で呼ばれたらthenReturnのものを返すというもの
        Mockito.when(authRepository.findByUserId(userId)).thenReturn(Optional.of(userModel));
        //テスト対象メソッドを呼び出し
        UserHomeInfoDTO result = authService.verifyJWT(gTestJwt);
        //戻り値設定
        UserHomeInfoDTO userHomeInfoDTO= new UserHomeInfoDTO();
//        userHomeInfoDTO.setUserName("TANAKA");
        //テスト実行
        assertEquals(userHomeInfoDTO,result);
    }

    //正常系2
    @Test
    void testVerifyJWTOfContext()
    {
        //モック準備
        String userId="123";
        Mockito.when(authRepository.findByUserId(userId)).thenReturn(Optional.of(userModel));
        //テスト対象メソッドを呼び出し
        UserHomeInfoDTO result = authService.verifyJWT(gTestJwt);
        //戻り値設定
        UserHomeInfoDTO userHomeInfoDTO = new UserHomeInfoDTO();
        userHomeInfoDTO.setUserName("TANAKA");
        userHomeInfoDTO.setEmail("sample@yahoo.co.jp");
        assertEquals(userHomeInfoDTO.getUserName(),result.getUserName());
    }
*/
    /*
    //異常系1
    @Test
    void testVerifyNullOfToken()
    {
        gTestJwt=null;
        /*テスト対象メソッドを呼び出し
            第一引数に例外クラス
            第二引数に例外をスローするコード(ラムダ式)
            第三引数にはエラーがスローされない場合のエラーメッセージ
        /*
        InvalidTokenException exception = assertThrows(
                InvalidTokenException.class,
                ()-> authService.verifyJWT(gTestJwt),
                "例外がスロー出来ませんでした..."
        );
        //スローされた例外のメッセージを検証
        assertEquals("Token is null or empty",exception.getMessage());
    }
    //異常系2
    @Test
    void testVerifyNullOfEmpty()
    {
        gTestJwt="";
        InvalidTokenException exception = assertThrows(
                InvalidTokenException.class,
                ()-> authService.verifyJWT(gTestJwt),
                "例外がスロー出来ませんでした..."
        );
        //スローされた例外のメッセージを検証
        assertEquals("Token is null or empty",exception.getMessage());
    }
*/
}