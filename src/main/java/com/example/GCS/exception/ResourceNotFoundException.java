package com.example.GCS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
@ResponseStatus(HttpStatus.NOT_FOUND)
    このアノテーションを付けることで、この例外が発生したときに自動的に
    404 (Not Found) ステータスコードが返されます。
[コンストラクタ
    super(message) を呼び出して、
    親クラス RuntimeException にエラーメッセージを渡します。
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
