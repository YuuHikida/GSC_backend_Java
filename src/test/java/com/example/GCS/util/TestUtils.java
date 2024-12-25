package com.example.GCS.util;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;


public class TestUtils {

    public static String createMockToken() throws FirebaseAuthException {
        String testUid = "test-user";

        try {
            // 既存ユーザーを削除（存在しない場合は無視）
            FirebaseAuth.getInstance().deleteUser(testUid);
        } catch (FirebaseAuthException e) {
            System.out.println("User does not exist or cannot be deleted: " + e.getMessage());
        }
        // Firebase Authユーザ情報を作成
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setUid(testUid)
                .setEmail("test@example.com")
                .setEmailVerified(true)
                .setDisplayName("Test User")
                .setPhotoUrl("http://www.example.com/test.png")
                .setDisabled(false);

        // ユーザーを作成
        UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
        // モックトークン生成
        String token = FirebaseAuth.getInstance().createCustomToken(userRecord.getUid());
//        System.out.println("Token is "+token);
        return token;
    }
}