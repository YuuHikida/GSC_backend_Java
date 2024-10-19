package com.example.GCS.service;

import com.example.GCS.model.UserModel;

import com.example.GCS.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    * 概要   : ユーザ情報を1件取得
    * 戻り値 : UserModel...
    * */
    public UserModel GetOneUsersInformation(){
        //userModel作成
        // MongoDBAtlas初期化&送る
        //(nullチェック)
        //モデルを返す

        //return userRepository.save(user);
        return new UserModel("1","TANAKA","sample@yahoo.co.jp","21:00");
    }

}
