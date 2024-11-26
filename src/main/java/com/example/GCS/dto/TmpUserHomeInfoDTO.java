package com.example.GCS.dto;

import lombok.Data;

/*
 * 概要:新規でログインしたユーザーの情報をDBに送る用
 * (フロントには送らない)
 */
@Data
public class TmpUserHomeInfoDTO {
    private String userName;
    private String email;
    private String userId;
}
