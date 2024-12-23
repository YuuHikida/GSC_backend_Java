package com.example.GCS.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;


@Configuration
public class FirebaseConfig {

    @Value("${service.account.path}")
    private String serviceAccountPath;

    @PostConstruct
    public void initializeFirebase() {
        try {
            // サービスアカウントキーのパスを指定して読み込み
            FileInputStream serviceAccount = new FileInputStream(serviceAccountPath);

            // Firebaseを初期化
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Firebaseが正常に初期化されました！");
        } catch (IOException e) {
            // エラーが発生した場合の処理
            System.out.println("Firebaseの初期化に失敗しました: " + e.getMessage());
            e.printStackTrace();
        }
    }
}