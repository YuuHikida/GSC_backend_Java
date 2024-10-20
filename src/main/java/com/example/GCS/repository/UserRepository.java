package com.example.GCS.repository;


import com.example.GCS.model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface UserRepository extends MongoRepository<UserModel,String> {

    //gitNameで検索するクエリメソッド
    UserModel findByGitName(String gitName);

}
