package org.example.demo.web.dto.member;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MyPagePostDto {
    Integer file_id;
    String title;
    String description;
    public MyPagePostDto(Integer file_id,String title,String description) {
        this.file_id = file_id;
        this.title = title;
        this.description = description;
    }
}
