package org.example.demo.web.dto.member;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MyPagePostDto {
    Integer id;
    String image;
    String title;
    String description;
    public MyPagePostDto(Integer id, String image,String title,String description) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
    }
}
