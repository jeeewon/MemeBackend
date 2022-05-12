/*
package org.example.demo.web;
import org.springframework.http.MediaType;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.example.demo.domain.posts.Posts;
//import org.example.demo.domain.posts.PostsCategory;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.web.dto.PostsSaveRequestDto;
//import org.example.demo.web.dto.PostsUpdateRequestDto;
import org.example.demo.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {
/*
    @LocalServerPort
    private Integer port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private PostsRepository postsRepository;


    @After
    public void tearDown() throws Exception {
        this.postsRepository.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception {
        Integer meme_kind = 1;
        Integer cate_seq = 1;
        String title = "테스트 게시글";
        String image = "이미지처리";
        String explain = "테스트 본문";
        String example = "예시";
        String keyw = "keyword1";
        String keyww = "keyword2";
        String keywww = "keyword3";
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .meme_kind(meme_kind)
                .cate_seq(cate_seq)
                .title(title)
                .image(image)
                .explain(explain)
                .example(example)
                .keyw(keyw)
                .keyww(keyww)
                .keywww(keywww)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";
        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
        //then
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = this.postsRepository.findAll();
        Assertions.assertThat(all.get(0).getMeme_kind()).isEqualTo(meme_kind);
        Assertions.assertThat(all.get(0).getCate_seq()).isEqualTo(cate_seq);
        Assertions.assertThat(all.get(0).getTitle()).isEqualTo(title);
        Assertions.assertThat(all.get(0).getImage()).isEqualTo(image);
        Assertions.assertThat(all.get(0).getExplain()).isEqualTo(explain);
        Assertions.assertThat(all.get(0).getExample()).isEqualTo(example);
        Assertions.assertThat(all.get(0).getKeyw()).isEqualTo(keyw);
        Assertions.assertThat(all.get(0).getKeyww()).isEqualTo(keyww);
        Assertions.assertThat(all.get(0).getKeywww()).isEqualTo(keywww);
    }

    @Test
    public void Posts_수정된다() throws Exception{
        //given
        Posts savedPosts = postsRepository.save(Posts.builder()
                .title("title")
                .explain("explain")
                .m_seq(1)
                .build());

        Long updateId = savedPosts.getBoard_seq();
        String expectedTitle = "title2";
        String expectedContent = "content2";

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
                .title(expectedTitle)
                .explain(expectedContent)
                .build();

        String url = "http://localhost:"+port+"/api/v1/posts/"+updateId;
        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT,requestEntity,Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getExplain()).isEqualTo(expectedContent);
    }*/
}

*/