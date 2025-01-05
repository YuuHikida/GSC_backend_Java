package com.example.GCS.controller;

import com.example.GCS.dto.TokenRequestDTO;
import com.example.GCS.dto.UserHomeInfoDTO;
import com.example.GCS.service.auth.AuthService;
import com.example.GCS.service.auth.TokenVerifier;

import com.nimbusds.oauth2.sdk.Response;
import com.nimbusds.openid.connect.sdk.AuthenticationRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.security.GeneralSecurityException;

/*
 * 概要:クライアントからIDトークンを受け取り、検証する
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    /*
     public ResponseEntity<T> {
    private HttpStatus status;       // ステータスコード (200, 400, 500 など)
    private HttpHeaders headers;     // HTTPヘッダー
    private T body;                   // レスポンスボディ（JSONなどのデータ）
     */

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody TokenRequestDTO tokenRequestDTO, HttpServletResponse response)
    {
        //フロントからの引数検証
        authService.login(tokenRequestDTO);

        //フロントへの戻り値
        UserHomeInfoDTO userHomeInfoDTO = new UserHomeInfoDTO();
        return ResponseEntity.ok(userHomeInfoDTO);
    }



    //以下仕様変更に伴いボツ
//    /*
//     * 概要 : フロントから受け取ったトークンを確認してデータを返す
//     * 、token が JSONのボディ に含まれている場合、@RequestParam ではなく @RequestBody を使う必要がある
//     */
//    @PostMapping("/authenticate")
//    public ResponseEntity<?> authenticateAndUserName_UserEmail(@RequestHeader("Authorization") String  authHeader) throws GeneralSecurityException, IOException {
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            System.out.println("first error return");
//            return ResponseEntity.badRequest().body("Missing or invalid Authorization header");
//        }
//        // トークンを抽出
//        String token = authHeader.replace("Bearer ", "").trim();
//        System.out.println("Token is: " + token);
//
//        boolean isValid = true;
//        if(!isValid)
//        {
//            System.out.println("invalid token");
//            return ResponseEntity.status(401).body("Invalid token");
//        }
//
//       //戻り値設定
//        UserHomeInfoDTO userHomeInfoDTO= new UserHomeInfoDTO();
//        userHomeInfoDTO.setUserName("TANAKA");
//        userHomeInfoDTO.setEmail("sample@yahoo.co.jp");
//
//        return ResponseEntity.ok(userHomeInfoDTO);
//    }
//
//    @PostMapping("/testAuthenticate")
//    public String TestGetMethod(@RequestHeader("Authorization") String  authHeader) throws GeneralSecurityException, IOException {
//        System.out.println("authHeader is = " + authHeader);
//        System.out.println("authenticate is alive");
//        return "Hello,World";
//    }

}
