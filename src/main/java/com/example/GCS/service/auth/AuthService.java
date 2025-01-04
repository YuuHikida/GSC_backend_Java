package com.example.GCS.service.auth;

import com.example.GCS.dto.UserHomeInfoDTO;
import com.example.GCS.exception.InvalidTokenException;
import com.example.GCS.repository.AuthRepository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.http.Cookie;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/*
 * 概要:JWT検証およびcookieその周りの操作
 */
@Service
public class AuthService {

    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    /**
     * 概要:トークンを検証し、JWTに格納されているユーザー情報を返す
     *
     * @param token Googleログインから受け取ったIDトークン
     * @return FirebaseToken ... トークンに含まれる情報を返す
     */
    public FirebaseToken verifyJWT(String token) {
        //引数チェック
        if (token == null || StringUtils.isEmpty(token) || !token.startsWith("Bearer ")) {
            throw new InvalidTokenException("Token is null or empty");
        }
        //トークンを抽出
        String trimToken = token.replace("Bearer ", "").trim();
        //ここにデバックプリント文クラスとか作りたいなぁ
        System.out.println("トリム後のトークン: " + trimToken);
        // JWTの検証
        try {
            FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(trimToken);
            System.out.println("トークンの検証成功: " + firebaseToken);
            return firebaseToken;
        } catch (Exception e) {
            System.err.println("トークンの検証失敗: " + e.getMessage());
            throw new IllegalArgumentException("無効なトークンです: " + e.getMessage());
        }
    }
    public Cookie createHttpsOnlyCookies(String name,String value)
    {
        return new Cookie("tanaka","123");
    }
    //ここでログイン検証用関数を作成↓

}
