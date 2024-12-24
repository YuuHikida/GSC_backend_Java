package com.example.GCS.util;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;


public class TestUtils {

    public static String createMockToken() throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setUid("test-user")
                .setEmail("test@example.com")
                .setEmailVerified(true)
                .setDisplayName("Test User")
                .setPhotoUrl("http://www.example.com/test.png")
                .setDisabled(false);

        // ユーザーを作成
        UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);

        // モックトークン生成
        return FirebaseAuth.getInstance().createCustomToken(userRecord.getUid());
    }
}