package com.example.GCS.service;

import com.example.GCS.model.UserModel;

import com.example.GCS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    * 概要   : (gitNameで)ユーザ情報を1件取得
    * 戻り値 : UserModel...
    * */
    public UserModel GetOneUsersInformation(String gitName){
        return userRepository.findByGitName(gitName);

    }

}
