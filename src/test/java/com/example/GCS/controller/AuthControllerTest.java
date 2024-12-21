package com.example.GCS.controller;

import com.example.GCS.config.TestSecurityConfig;
import com.example.GCS.dto.UserHomeInfoDTO;
import com.example.GCS.service.auth.TokenVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser; // 追加
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// MockMvcRequestBuilders用↓
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//CSRF用↓
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@WebMvcTest(AuthController.class)   //テスト対象のController指定
@Import(TestSecurityConfig.class) // テスト用SecurityConfigを読み込む
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private String gTestJwt;

    //事前のテスト
    @BeforeEach
    void setup() {
        // ダミーのJWTトークンを生成（本来はJwtUtilなどを使う）
        gTestJwt = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0VXNlciIsImlhdCI6MTY5NzU3MTQwMCwiZXhwIjoxNjk3NTc1MDAwfQ.somemocksignature";
    }

    // 正常系
    @Test
    @WithMockUser(username = "testUser", roles = {"USER"})        // 認証されたユーザーとしてテスト
    void testReturnGoodReqAuth() throws Exception {

        //期待するレスポンス
        var userHomeInfoDTO = new UserHomeInfoDTO();
        userHomeInfoDTO.setUserName("TANAKA");
        userHomeInfoDTO.setEmail("sample@yahoo.co.jp");
        String expectedJson = objectMapper.writeValueAsString(userHomeInfoDTO);

        //test 実行
        /*mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
         * ↑はHTTPリクエストをシミュレートしてくれる
         */
        mockMvc.perform(post("/auth/authenticate")
                        .with(csrf()) // CSRFトークンを追加
                        .header("Authorization", gTestJwt) // AuthorizationヘッダーにJWTを設定
                        .contentType(MediaType.APPLICATION_JSON))    //JSON形式のリクエストを指定
                .andExpect(status().isOk())               //HTTP200_OKを期待
                .andExpect(content().json(expectedJson));
    }

    //異常系
    @Test
    @WithMockUser(username = "testUser", roles = {"USER"})
    void testAuthenticateWithMissingJwt() throws Exception {
        gTestJwt = "Bebebebe";
        // JWTが欠けているリクエスト
        mockMvc.perform(post("/auth/authenticate")
                        .with(csrf()) // CSRFトークンを追加
                        .header("Authorization", gTestJwt)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()); // JWTがない場合は 400 Bad Request を期待
    }

    //異常系2
    @Test
    @WithMockUser(username = "testUser", roles = {"USER"})
    void testAuthenticateWithMissingJwt2() throws Exception {
        // JWTが欠けているリクエスト
        mockMvc.perform(post("/auth/authenticate")
                        .with(csrf()) // CSRFトークンを追加
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()); // JWTがない場合は 400 Bad Request を期待
    }



    /*
    * なぜ @WithMockUser を付与すると認証できるのか？
    1. セキュリティコンテキストの設定
    @WithMockUser を使用すると、テスト実行時に Spring Security が内部的にセキュリティコンテキストにモックされた認証情報を設定します。
    * これにより、テスト中のリクエストはあたかも認証済みのユーザーからのものであるかのように扱われます。

    2. フィルターのバイパス
    通常、Spring Security は認証されていないリクエストに対してリダイレクト（例: 302ステータスコード）を返します。
    * しかし、@WithMockUser を使用することで、セキュリティフィルターが認証済みと見なすため、リダイレクトが発生せず、
    * テスト対象のエンドポイントが正常に呼び出されます
 * */
    @Test
    @WithMockUser(username = "testUser", roles = {"USER"})
    // 認証されたユーザーとしてテスト
    void TestGetMethod() throws Exception {
        mockMvc.perform(get("/auth/testAuthenticate"))
                .andExpect(status().isOk());    //←HTTPステータスを検証

    }
}