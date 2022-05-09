package org.example.demo.domain.posts;

import java.time.LocalDateTime;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    public PostsRepositoryTest() {
    }

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        Integer meme_kind = 1;
        Integer cate_seq = 1;
        String title = "테스트 게시글";
        String image = "이미지처리";
        String explain = "테스트 본문";
        String example = "예시";
        String keyw = "keyword1";
        String keyww = "keyword2";
        String keywww = "keyword3";

        this.postsRepository.save(Posts.builder()
                .meme_kind(meme_kind)
                .cate_seq(cate_seq)
                .title(title)
                .image(image)
                .explain(explain)
                .example(example)
                .keyw(keyw)
                .keyww(keyww)
                .keywww(keywww)
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getMeme_kind()).isEqualTo(meme_kind);
        assertThat(posts.getCate_seq()).isEqualTo(cate_seq);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getImage()).isEqualTo(image);
        assertThat(posts.getExplain()).isEqualTo(explain);
        assertThat(posts.getExample()).isEqualTo(example);
        assertThat(posts.getKeyw()).isEqualTo(keyw);
        assertThat(posts.getKeyww()).isEqualTo(keyww);
        assertThat(posts.getKeywww()).isEqualTo(keywww);

    }
    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2022,5,5,0,0,0);
        postsRepository.save(Posts.builder()
                .meme_kind(1)
                .cate_seq(1)
                .title("title")
                .image("url")
                .explain("content")
                .example("example")
                .keyw("keyword1")
                .keyww("keyword2")
                .keywww("keyword3")
                .build());
        ;
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
