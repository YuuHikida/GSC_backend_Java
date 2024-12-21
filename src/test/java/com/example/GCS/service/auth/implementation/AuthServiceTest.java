package com.example.GCS.service.auth.implementation;

import com.example.GCS.dto.TmpUserHomeInfoDTO;
import com.example.GCS.dto.UserHomeInfoDTO;
import com.example.GCS.exception.InvalidTokenException;
import com.example.GCS.model.UserModel;
import com.example.GCS.repository.AuthRepository;
import com.example.GCS.service.auth.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import io.github.cdimascio.dotenv.Dotenv;


import java.util.Optional;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


public class AuthServiceTest {

    @Mock
    private AuthRepository authRepository;

    @InjectMocks
    private AuthService authService;

    private String gTestJwt;
    private UserModel userModel;

    @BeforeEach
    void setup() {
        // Mockitoのモック初期化
        MockitoAnnotations.openMocks(this);
        // ダミーのJWTトークンを生成（本来はJwtUtilなどを使う）
        gTestJwt = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0VXNlciIsImlhdCI6MTY5NzU3MTQwMCwiZXhwIjoxNjk3NTc1MDAwfQ.somemocksignature";
        userModel = new UserModel("987","TANAKA","sample@yahoo.co.jp","19:19","123");
    }

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

    //異常系1
    @Test
    void testVerifyNullOfToken()
    {
        gTestJwt=null;
        /*テスト対象メソッドを呼び出し
            第一引数に例外クラス
            第二引数に例外をスローするコード(ラムダ式)
            第三引数にはエラーがスローされない場合のエラーメッセージ
        * */
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
}