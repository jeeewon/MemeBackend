/*package org.example.demo.web;

import org.example.demo.config.WebMvcConfig;
import org.example.demo.config.WebSecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(
        controllers = HelloController.class,
        excludeFilters={
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = WebSecurityConfig.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = WebMvcConfig.class)
        }
)
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    public HelloControllerTest() {
    }

    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello"))
                .andDo(print()) //Log 내용
                .andExpect(status().isOk()) //상태 이상 체크
                .andExpect(content().string("hello")); //내용에 "hello"가 있는지 유무
    }

    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)));
                /*.andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));*/
  /*  }
}*/