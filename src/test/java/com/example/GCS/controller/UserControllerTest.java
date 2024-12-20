package com.example.GCS.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

import com.example.GCS.model.UserModel;
import com.example.GCS.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

//    @Test
//    public void testUserHomeInfo_ShouldReturnHello() throws Exception {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("hello"));
//    }
    @Test
    public void testGetOneUsersInformation() throws Exception{
        //モックデータを作成
        UserModel mockModel = new UserModel("1","TANAKA","sample@yahoo.co.jp","23:00","114514");

        // モックの動作を定義
        when(userService.GetOneUsersInformation("TANAKA")).thenReturn(mockModel);

        // Getリクエストテスト
        MvcResult result = mockMvc.perform(get("/TANAKA"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.gitName",is("TANAKA")))
                .andReturn();  // レスポンス全体を取得

        // レスポンスボディを文字列として取得
        String jsonResponse = result.getResponse().getContentAsString();

        // レスポンスをコンソールに表示
        System.out.println("JSON Response: " + jsonResponse);

    }



    // 取得したJsonデータを取得
//    @Test
//    public void testGetUser() throws Exception {
//        // リクエストの実行
//        MvcResult result = mockMvc.perform(get("/TANAKA"))
//                .andExpect(status().isOk())  // ステータスコード 200 OK を期待
//                .andReturn();  // レスポンス全体を取得
//
//        // レスポンスボディを文字列として取得
//        String jsonResponse = result.getResponse().getContentAsString();
//
//        // レスポンスをコンソールに表示
//        System.out.println("JSON Response: " + jsonResponse);
//    }

}
