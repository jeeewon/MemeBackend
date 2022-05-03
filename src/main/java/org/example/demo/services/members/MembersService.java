package org.example.demo.services.members;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.members.MembersRepository;
import org.example.demo.web.dto.MembersSaveRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MembersService {
    private final MembersRepository membersRepository;

    @Transactional
    public Integer save(MembersSaveRequestDto requestDto){
        return membersRepository.save(requestDto.toEntity()).getM_seq();
    }
}