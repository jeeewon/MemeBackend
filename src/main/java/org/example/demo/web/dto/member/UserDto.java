package org.example.demo.web.dto.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String token;
    @NotEmpty
    @Size(min=5, max=10)
    private String email;
    @NotEmpty
    @Size(min=5, max=10)
    private String password;
    @NotEmpty
    private String passwordConfirm;
    private Long id;
}
