package com.example.GCS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
[@ExceptionHandler(ResourceNotFoundException.class)]
ResourceNotFoundException がスローされた場合に
このメソッドが呼び出されます。

[ResponseEntity]
    Spring が HTTP レスポンスを作成するためのクラス
    この例では 404 (Not Found) ステータスコードと、
    エラーメッセージをボディに含むレスポンスを返しています。
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 401 Unauthorizedエラーをハンドリング
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorizedException(UnauthorizedException e) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED) // HTTPステータス: 401
                .body("Unauthorized: " + e.getMessage()); // メッセージをレスポンスボディに設定
    }

    // 404 Not Foundエラーをハンドリング
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND) // HTTPステータス: 404
                .body("Resource not found: " + e.getMessage());
    }

    // 500 Internal Server Errorをハンドリング
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR) // HTTPステータス: 500
                .body("Internal Server Error: " + e.getMessage());
    }
}
