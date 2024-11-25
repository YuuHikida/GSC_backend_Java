package com.example.GCS.controller;

import com.example.GCS.dto.UserHomeInfoDTO;
import com.example.GCS.service.auth.TokenVerifier;
import com.example.GCS.service.auth.implenebtation.GoogleAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Map;

/*
 * 概要:クライアントからIDトークンを受け取り、検証する
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final TokenVerifier tokenVerifier;

    @Autowired
    public AuthController(GoogleAuthService googleAuthService, TokenVerifier tokenVerifier) {
        this.tokenVerifier = tokenVerifier;
    }

    /*
     * 概要 : フロントから受け取ったトークンを確認してデータを返す
     * 、token が JSONのボディ に含まれている場合、@RequestParam ではなく @RequestBody を使う必要がある
     */
    @PostMapping("/authenticate")
    public UserHomeInfoDTO authenticateAndUserName_UserEmail(@RequestBody Map<String, String> payload) throws GeneralSecurityException, IOException
    {
        System.out.println("Received payload: " + payload); //dbg
        String token = payload.get("token");
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token is missing or empty");
        }
        // トークン検証コード(Google)
        return tokenVerifier.verifyToken(token);
    }

    // 実験的に作成
//    @PostMapping("/receiveJwt")
//    public ResponseEntity<String> receiveJwt(@RequestBody Map<String, String> payload) throws InterruptedException {
//        String jwt = payload.get("token"); // フロントエンドから送られたJWTを取得
//        System.out.println("(バックエンド)受け取ったJWT: " + jwt);
//
//        // 必要ならここでJWTの検証処理を追加
//        // 例: Googleの公開鍵で署名を検証
//        return ResponseEntity.ok("JWTを受け取りました！");
//    }
}
