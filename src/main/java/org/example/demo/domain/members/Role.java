package org.example.demo.domain.members;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("ROLE_USER",1);
    private final String key;
    private final Integer m_status;

}
