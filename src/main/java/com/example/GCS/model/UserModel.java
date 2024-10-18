package com.example.GCS.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // 全フィールドを引数に持つコンストラクタを生成
public class UserModel {
    private String 	gitName;
    private String  mail ;
    private String time;

}
