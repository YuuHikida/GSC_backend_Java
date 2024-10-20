package com.example.GCS;

import org.springframework.boot.SpringApplication;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GithubContributeSystemApplication {

	public static void main(String[] args) {
		// 環境変数install
		Dotenv dotenv = Dotenv.load();
		String mongoUri = dotenv.get("spring.data.mongodb.uri");
//		if (mongoUri == null) {
//			System.out.println("MONGODB_URI is null. Please check .env file.");
//		} else {
//			System.setProperty("MONGODB_URI", mongoUri);
//		}

        if (mongoUri != null) {
            System.setProperty("spring.data.mongodb.uri", mongoUri);
        }
        SpringApplication.run(GithubContributeSystemApplication.class, args);
	}


}
