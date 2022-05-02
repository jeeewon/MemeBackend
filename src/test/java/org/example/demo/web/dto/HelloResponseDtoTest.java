package org.example.demo.web.dto;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;

public class HelloResponseDtoTest {
    public HelloResponseDtoTest() {
    }

    @Test
    public void 롬복_기능_테스트() {
        String name = "test";
        int amount = 1000;
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        AssertionsForClassTypes.assertThat(dto.getName()).isEqualTo(name);
        AssertionsForClassTypes.assertThat(dto.getAmount()).isEqualTo(amount);
    }
}