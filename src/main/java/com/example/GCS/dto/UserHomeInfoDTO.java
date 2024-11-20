package com.example.GCS.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserHomeInfoDTO {
    private String userName;
    private String email;

}
