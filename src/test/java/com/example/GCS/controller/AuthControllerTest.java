package com.example.GCS.controller;

import com.example.GCS.dto.UserHomeInfoDTO;
import com.example.GCS.service.auth.TokenVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.security.test.context.support.WithMockUser; // 追加
import static org.apache.http.client.methods.RequestBuilder.post;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)   //テスト対象のController指定
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    private ObjectMapper objectMapper;
//    private TokenVerifier tokenVerifier;

    @Test
    @WithMockUser(username = "testUser",roles = {"USER"}) // 認証されたユーザーとしてテスト
    void TestGetMethod() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/auth/testAuthenticate"))
                .andExpect(status().isOk());    //←HTTPステータスを検証
    }
//    @Test
//    void testAuth() throws Exception{
//        var userHomeInfoDTO = new UserHomeInfoDTO();
//        var objectMapper = new ObjectMapper();
//
//        // testデータ準備
//        userHomeInfoDTO = new UserHomeInfoDTO();
//        String returnAns = objectMapper.writeValueAsString(userHomeInfoDTO);
//
//        //test 実行
//        /*mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
//        * ↑はHTTPリクエストをシミュレートしてくれる
//        */
//         */
//        mockMvc.perform(
//         */
//                post("/authenticate")
//                        .content(objectMapper.writeValueAsString())
//                        .contentType()
//                ).andExpect(status(),isCreated());
//
//    }
}