package com.example.GCS.service;

import com.example.GCS.dto.UserHomeInfoDTO;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

/*
概要:GCSのHome画面操作
 */
@Service
public class HomeService {

    /*
    概要:ログイン後、OAuth2.0の情報を返す
     */
    public UserHomeInfoDTO getUserInfoFromOAuth2(OAuth2AuthenticationToken authentication)
    {
        UserHomeInfoDTO userHomeInfoDTO = new UserHomeInfoDTO();
        // ユーザー情報を取得
        String tmpName = authentication.getPrincipal().getAttributes().get("name").toString();
        userHomeInfoDTO.setUserName(tmpName);
        String tmpEmail = authentication.getPrincipal().getAttributes().get("email").toString();
        userHomeInfoDTO.setEmail(tmpEmail);

        return userHomeInfoDTO;
    }
}
