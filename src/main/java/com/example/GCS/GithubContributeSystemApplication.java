package com.example.GCS;

import org.springframework.boot.SpringApplication;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GithubContributeSystemApplication {

	public static void main(String[] args) {
		// 環境変数install
		Dotenv dotenv = Dotenv.load();

		// MongoDB URIの設定
		String mongoUri = dotenv.get("MONGODB_URI");
		if (mongoUri == null) {
			System.out.println("MONGODB_URI is null. Please check .env file.");
		} else {
			System.setProperty("MONGODB_URI", mongoUri);
		}

		// クライアントID
		String googleClientID = dotenv.get("GOOGLE_CLIENT_ID");
		if (googleClientID == null) {
			System.out.println("GOOGLE_CLIENT_SECRET is null. Please check .env file.");
		} else {
			System.setProperty("GOOGLE_CLIENT_ID", googleClientID);
		}

		// Google認証の変数をデバッグ出力して確認
		String googleClientSecret = dotenv.get("GOOGLE_CLIENT_SECRET");
		if (googleClientSecret == null) {
			System.out.println("GOOGLE_CLIENT_SECRET is null. Please check .env file.");
		} else {
			System.setProperty("GOOGLE_CLIENT_SECRET", googleClientSecret);
		}

		String googleScope = dotenv.get("GOOGLE_SCOPE");
		if (googleScope == null) {
			System.out.println("GOOGLE_SCOPE is null. Please check .env file.");
		} else {
			System.setProperty("GOOGLE_SCOPE", googleScope);
		}

		String googleRedirectUri = dotenv.get("GOOGLE_REDIRECT_URIS");
		if (googleRedirectUri == null) {
			System.out.println("GOOGLE_REDIRECT_URIS is null. Please check .env file.");
		} else {
			System.setProperty("GOOGLE_REDIRECT_URI", googleRedirectUri);
		}

		// store password
		String storePassword = dotenv.get("KEY_STORE_PASSWORD");

		System.out.println("MongoDB URI: " + mongoUri);
		System.out.println("Google Client ID: " + googleClientID);
		System.out.println("Google Client Secret: " + googleClientSecret);
		System.out.println("Google Scope: " + googleScope);
		System.out.println("Google Redirect URI: " + googleRedirectUri);
		System.out.println("★store password:"+storePassword);

		SpringApplication.run(GithubContributeSystemApplication.class, args);
	}
}
