package com.example.GCS.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    /* 概要:エンドポイントへのアクセス制御
     *
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // 必要に応じてCSRFを無効化
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/auth/**").permitAll()
//                        .requestMatchers("/", "/login", "/oauth2/**", "/auth/authenticate","/receiveJwt").permitAll()
                        .anyRequest().authenticated()
                )
                .cors(cors -> cors.configurationSource(corsConfigurationSource())); // CORS設定を追加

        return http.build();
    }

    /* 概要: CORS設定の定義
     * 許可するオリジン (addAllowedOrigin)          ...どのオリジンからリクエスト許可するか指定
     * 許可するHTTPメソッド (setAllowedMethods)     ...GET, POST, PUT, DELETE など、どのHTTPメソッドを許可するかを指定
     * 許可するヘッダー (setAllowedHeaders)         ...ライアントが送信できるリクエストヘッダーを指定
     * 認証情報の共有 (setAllowCredentials)         ...クッキーや認証ヘッダーを含むリクエストを許可するかどうかを指定
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("http://localhost:*");   // ローカル開発環境を許可
        // フロントエンドの固定IPを許可
        config.addAllowedOrigin("http://192.168.200.101:3000"); // フロントエンドの固定IPとポート
        config.addAllowedOrigin("http://frontend:3000");       // コンテナ名経由のアクセス

        // オリジンを1つずつ明示的に追加
//        config.addAllowedOrigin("http://localhost:3000");
//        config.addAllowedOrigin("http://localhost:3000/");
//        config.addAllowedOrigin("http://172.28.16.1.nip.io:3000");

        // 必要なHTTPメソッドを明示
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // 許可するヘッダーを限定
//        config.setAllowedHeaders(List.of("Content-Type", "Authorization"));
        config.setAllowedHeaders(List.of("*"));

        // 認証情報を含むリクエストを許可
        config.setAllowCredentials(true); // ここをtrueにしてる時はオリジン(addAllowedOrigin)をワイルドカード('*')指定できない

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
