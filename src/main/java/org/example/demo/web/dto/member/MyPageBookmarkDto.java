package org.example.demo.web.dto.member;

import lombok.Getter;

@Getter
public class MyPageBookmarkDto {
    Integer id;
    Integer file_id;
    String title;
    String description;

    public MyPageBookmarkDto(Integer id,Integer file_id,String title,String description) {
        this.id = id;
        this.file_id = file_id;
        this.title = title;
        this.description = description;
    }
}
