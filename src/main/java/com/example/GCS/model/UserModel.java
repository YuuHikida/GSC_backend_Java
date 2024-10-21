package com.example.GCS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor // 全フィールドを引数に持つコンストラクタを生成
@Document(collection = "user")
public class UserModel {
    @Id
    private String id;
    @Field("git_name")
    private String gitName;
    private String mail ;
    private String time;

}