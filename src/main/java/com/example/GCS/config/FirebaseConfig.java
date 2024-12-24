package com.example.GCS.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@Configuration
public class FirebaseConfig {


    @PostConstruct
    public void initializeFirebase() {
        try {
            // .envからサービスアカウントのパスを読み込み
            Dotenv dotenv = Dotenv.load();
            String serviceAccountPath  = dotenv.get("SERVICE_ACCOUNT_PATH");

            //サービスアカウントのストリーム作成
            InputStream serviceAccountStream  = new FileInputStream(serviceAccountPath);

            // Firebaseを初期化
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccountStream ))
                    .build();

            //初期化
            FirebaseApp.initializeApp(options);

            System.out.println("Firebaseが正常に初期化されました！");
        } catch (IOException e) {
            // エラーが発生した場合の処理
            System.out.println("Firebaseの初期化に失敗しました: " + e.getMessage());
            e.printStackTrace();
        }
    }
}