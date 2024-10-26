package com.example.GCS.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Controller
public class GoogleOauthController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/done")
    public String done(@RequestParam("credential") String credential, Model model) {
        try {
            // Google IDトークンの検証
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                    new NetHttpTransport(), GsonFactory.getDefaultInstance())
                    .setAudience(Collections.singletonList("あなたのクライアントIDをここに入力"))
                    .build();

            GoogleIdToken idToken = verifier.verify(credential);
            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();

                String userId = payload.getSubject();
                String email = payload.getEmail();
                String name = (String) payload.get("name");

                // ユーザー情報をモデルに追加
                model.addAttribute("userId", userId);
                model.addAttribute("email", email);
                model.addAttribute("name", name);

                return "done"; // 成功ページへ
            } else {
                model.addAttribute("error", "Invalid ID token.");
                return "error"; // エラーページへ
            }
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "Verification failed.");
            return "error"; // エラーページへ
        }
    }
}
