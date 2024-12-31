package com.example.GCS.service.auth.implementation;

import com.example.GCS.config.FirebaseConfig;
import com.example.GCS.repository.AuthRepository;
import com.example.GCS.service.auth.AuthService;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.example.GCS.util.TestUtils; // ユーティリティクラスのインポート

public class AuthServiceTest {
//test
    //仕様変更に伴い没
//    @Mock
//    private AuthRepository authRepository;
//    @Mock
//    private FirebaseAuth firebaseAuth;
//
//    @InjectMocks
//    private AuthService authService;
//
//    private String testJWT;
//
//    @BeforeEach
//    void setup()throws Exception {
//        // Firebase の初期化
//        FirebaseConfig firebaseConfig = new FirebaseConfig();
//        firebaseConfig.initializeFirebase();  // Firebase 初期化の呼び出し
//
//        // Mockitoのモック初期化
//        MockitoAnnotations.openMocks(this);
//
//        //モックトークン作成(テスト関数への入力値)
//        testJWT = "Bearer " + TestUtils.createMockToken(); // プレフィックスを追加
//    }
//
//    //正常系1(引数にjwtを渡し、正常にFireBaseTokenを返す)
//    @Test
//    void testNormalReturnJWT() throws FirebaseAuthException {
//        // 事前準備: モックFirebaseトークンを作成
//        FirebaseToken mockFirebaseToken = mock(FirebaseToken.class);
//
//        // Firebase認証結果として返すべきトークンをモック
//        when(firebaseAuth.verifyIdToken(testJWT)).thenReturn(mockFirebaseToken);
//
//        // 実行: JWTをverifyしてFirebaseTokenを取得
//        FirebaseToken result = authService.verifyJWT(testJWT);
//
//        // 結果がモックと一致するかを検証
//        assertEquals(mockFirebaseToken, result);
//    }
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