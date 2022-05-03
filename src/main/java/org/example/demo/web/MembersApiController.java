package org.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.example.demo.services.members.MembersService;
import org.example.demo.web.dto.MembersInfoRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MembersApiController {
    private final MembersService membersService;

    @PostMapping("/auth/signup")
    public Integer save(@RequestBody MembersInfoRequestDto requestsDto){
        return membersService.save(requestsDto);
    }
}
