package com.example.GCS.repository;


import com.example.GCS.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface UserRepository extends MongoRepository<UserModel,String> {

    //gitNameで検索するクエリメソッド
    UserModel findByGitName(String gitName);

}
