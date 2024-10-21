package com.example.GCS.repository;

import com.example.GCS.model.UserModel;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@TestPropertySource(properties = "spring.data.mongodb.uri=${MONGODB_URI}")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    static void setUp() {
        Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename(".env.test").load();
        String mongoUri = dotenv.get("MONGODB_URI");
        if (mongoUri != null) {
            System.setProperty("spring.data.mongodb.uri", mongoUri);
            System.out.println("成功しました!!!!!!!!!!!!!!!!:"+mongoUri);
        } else {
            throw new IllegalStateException("MONGODB_URI not found in .env.test");
        }
    }

    @Test
    void testFindExistingDataInProduction() {
        // 既存データがあるか確認
        UserModel foundUser = userRepository.findByGitName("TANAKA");

        // アサーション
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getGitName()).isEqualTo("TANAKA");
    }
}