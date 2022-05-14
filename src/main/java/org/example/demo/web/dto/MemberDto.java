package org.example.demo.web.dto;

import lombok.*;
import org.example.demo.domain.member.MemberEntity;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long m_seq;
    private String id;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .m_seq(m_seq)
                .id(id)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long m_seq, String id, String password) {
        this.m_seq = m_seq;
        this.id = id;
        this.password = password;
    }
}