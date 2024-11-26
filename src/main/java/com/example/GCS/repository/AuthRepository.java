package com.example.GCS.repository;

import com.example.GCS.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends MongoRepository<UserModel,String> {
    //userIdで検索するクエリメソッド
    //補足:Spring Data JPA や MongoDB のリポジトリでは、レコードが存在しない場合に対応するため、戻り値に Optional を使うのが一般的,らしい
    Optional<UserModel> findByUserId(String userId);
}
