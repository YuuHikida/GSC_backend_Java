package com.example.GCS.service;

import com.example.GCS.model.UserModel;

import com.example.GCS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<UserModel> GetOneUsersInformation(String gitName){
        return userRepository.findByGitName(gitName);
        //return userRepository.save(user);
        //return new UserModel("1","TANAKA","sample@yahoo.co.jp","21:00");
    }

}
