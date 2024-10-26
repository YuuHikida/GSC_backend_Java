package com.example.GCS.controller;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

/*
* 概要:認可を行う* */
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
public class GoogleOauthController
{

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView index(final ModelAndView mav) {
        mav.setViewName("index"); // テンプレートHTML指定
        return mav;
    }

    @PostMapping("/done")
    public ModelAndView done(final ModelAndView mav,
                             @RequestParam("credential") final String credential) {
        mav.setViewName("done");
        System.out.println("Received credential: " + credential);
        // トークンの検証処理をここに追加する
        return mav;
    }



    //ここにpostMapping
//    @PostMapping("/done")
//    public ModelAndView done(final ModelAndView mav,
//                             @RequestParam("clientId") final String clientId,
//                             @RequestParam("credential") final String credential,
//                             @RequestParam("select_by") final String selectBy,
//                             @RequestParam("g_csrf_token") final String gCsrfToken
//    ) throws GeneralSecurityException, IOException {
//        mav.setViewName("done"); // HTMLテンプレート指定
//        final GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), GsonFactory.getDefaultInstance())
//                .setAudience(Collections.singletonList(clientId))
//                .build();
//
//        final GoogleIdToken idToken = verifier.verify(credential);
//        if (idToken != null) {
//            GoogleIdToken.Payload payload = idToken.getPayload();
//            System.out.println("selectBy:" + selectBy);
//            System.out.println("gCsrfToken:" + gCsrfToken);
//            System.out.println("userId:" + payload.getSubject());
//            System.out.println("email:" + payload.getEmail());
//            System.out.println("emailVerified:" + payload.getEmailVerified());
//            System.out.println("name:" + payload.get("name"));
//            System.out.println("pictureUrl:" + payload.get("picture"));
//            System.out.println("locale:" + payload.get("locale"));
//            System.out.println("familyName:" + payload.get("family_name"));
//            System.out.println("givenName:" + payload.get("given_name"));
//
//        } else {
//            System.out.println("Invalid ID token.");
//        } return mav;
//    }

}
