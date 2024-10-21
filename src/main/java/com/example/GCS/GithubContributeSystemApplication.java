package com.example.GCS;

import org.springframework.boot.SpringApplication;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GithubContributeSystemApplication {

	public static void main(String[] args) {
		// 環境変数install
		Dotenv dotenv = Dotenv.load();
		String mongoUri = dotenv.get("MONGODB_URI");
		if (mongoUri == null) {
			System.out.println("MONGODB_URI is null. Please check .env file.");
		} else {
			System.setProperty("MONGODB_URI", mongoUri);
		}

        System.out.println("mongoURL!!!!!!!!!!!!"+mongoUri);
        SpringApplication.run(GithubContributeSystemApplication.class, args);
	}


}
