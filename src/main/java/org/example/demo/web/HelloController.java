package org.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    public HelloController() {
    }

    @GetMapping({"/hello"})
    public String hello() {
        return "hello";
    }

}
