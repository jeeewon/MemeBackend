package org.example.demo.web.dto.member;

import java.time.LocalDateTime;

public class MyPageBookmarkDto {
    Integer file_id;
    String title;
    String description;

    public MyPageBookmarkDto(Integer file_id,String title,String description) {
        this.file_id = file_id;
        this.title = title;
        this.description = description;
    }
}
