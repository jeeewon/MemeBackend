package org.example.demo.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.demo.domain.members.Members;

@Getter
@NoArgsConstructor
public class MembersInfoRequestDto {
    private String id;
    private String pw;

    @Builder
    public MembersInfoRequestDto(String id, String pw){
        this.id = id;
        this.pw = pw;
    }

    public Members toEntity(){
        return Members.builder()
                .id(id)
                .pw(pw)
                .build();
    }
}
