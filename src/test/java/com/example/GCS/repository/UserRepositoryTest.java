package com.example.GCS.repository;

import com.example.GCS.model.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@TestPropertySource(properties = "MONGODB_URI")
@ActiveProfiles("test") //テスト用のプロファイルを使用することで、本番環境のデータに影響を与えないようにする
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void testFindByGitName() {        // gitNameでユーザーを検索
        UserModel foundUser = userRepository.findByGitName("TANAKA");

        // 結果をアサート
        assertThat(foundUser).isNotNull();  // ユーザーが見つかったか確認
        assertThat(foundUser.getGitName()).isEqualTo("TANAKA");  // 名前が一致するか確認}
    }
}