// springSecurityを使うので不要
//package com.example.GCS.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import java.util.List;
//
//@Configuration
//public class CorsConfig {
//
//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowedOrigins(List.of(
//                "http://localhost:3000",
//                "http://172.28.16.1.nip.io:3000"
//        )); // フロントエンドのURLを許可
//        config.addAllowedMethod("GET");
//        config.addAllowedMethod("POST");
//        config.addAllowedMethod("OPTIONS"); // プリフライトリクエストを許可
//        config.addAllowedHeader("*"); // 必要なヘッダーを許可
//        config.setAllowCredentials(true); // 認証情報の送信を許可
//        config.setExposedHeaders(List.of("Location")); // リダイレクトに必要なヘッダーを追加
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//}
