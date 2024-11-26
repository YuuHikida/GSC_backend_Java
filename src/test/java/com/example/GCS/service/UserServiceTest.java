package com.example.GCS.service;

import com.example.GCS.model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;


//@SpringBootTest
@ExtendWith(MockitoExtension.class) //Spring のコンテキストを使用せず、Mockito を使った単体テストが可能
class UserServiceTest {

    //@Mockは依存するクラスやインターフェースを作成
    //@IngectMockは@Mockを付与したインスタンスを自動的に注入する
    @InjectMocks
    UserService userService;

    private UserModel mockUserModel;

    @BeforeEach
    public void setUp() {
        // テスト用のモックデータを作成
        mockUserModel = new UserModel("1", "tanaka", "tanaka@mail.com", "12:00","114514");
    }



    @Test
    public void TestGetOneUsersInformation()
    {
        UserModel result = userService.GetOneUsersInformation("TANAKA");

        assertNotNull(result);
        assertEquals("TANAKA",result.getGitName());

        // フィールドを連結して表示
        String userInfo = "ID: " + result.getId() +
                ", GitName: " + result.getGitName() +
                ", Mail: " + result.getMail() +
                ", Time: " + result.getTime();

        System.out.println(userInfo);

    }
}