package org.example.demo.web;

import org.example.demo.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
/*
    @RequestMapping(method= RequestMethod.GET)
    public void getMethod(@RequestHeader("Test-Header") String value) {
        System.out.println("Test-Header=" + value);
    }*/

