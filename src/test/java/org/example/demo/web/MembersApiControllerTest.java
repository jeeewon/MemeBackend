package org.example.demo.web;

import org.assertj.core.api.Assertions;
import org.example.demo.domain.members.Members;
import org.example.demo.domain.members.MembersRepository;
import org.example.demo.web.dto.MembersSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MembersApiControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private MembersRepository membersRepository;


    @After
    public void tearDown() throws Exception {
        this.membersRepository.deleteAll();
    }

    @Test
    public void members_회원가입() throws Exception {
        String id = "id";
        String pw = "pw";
        MembersSaveRequestDto requestDto = MembersSaveRequestDto.builder()
                .id(id)
                .pw(pw)
                .build();

        String url = "http://localhost:" + port + "/auth/signup";
        //when
        ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, requestDto, Integer.class);
        //then
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0);

        List<Members> all = membersRepository.findAll();
        Assertions.assertThat(all.get(0).getId()).isEqualTo(id);
        Assertions.assertThat(all.get(0).getPw()).isEqualTo(pw);
    }
}
