package com.example.GCS.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

/*
 * 概要:ユーザーの情報をフロントに送る用
 */
@Data
public class UserHomeInfoDTO {
    private String userName;
    private String email;

}
