package org.example.demo.domain.members;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MembersRepository membersRepository;

    @After
    public void cleanup(){
        membersRepository.deleteAll();
    }

    @Test
    public void 멤버정보_불러오기(){
        //given
        String id = "id123";
        String pw = "password";

        membersRepository.save(Members.builder()
                .id(id)
                .pw(pw)
                .build());

        //when
        List<Members> membersList = membersRepository.findAll();

        //then
        Members members = membersList.get(0);
        assertThat(members.getId()).isEqualTo(id);
        assertThat(members.getPw()).isEqualTo(pw);
    }
}
