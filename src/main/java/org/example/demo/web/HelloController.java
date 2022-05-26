package org.example.demo.web;

import org.example.demo.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

/*
    private static final Logger logger = LoggerFactory.getLogger(HelloController .class);


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(
            @RequestHeader(value="Accept") String accept,
            @RequestHeader(value="Accept-Language") String acceptLanguage,
            @RequestHeader(value="User-Agent", defaultValue="myBrowser") String userAgent,
            @RequestHeader(value="Host") String host
    ) {

        System.out.println("Accept: " + accept);
        System.out.println("Accept-Language: " + acceptLanguage);
        System.out.println("User-Agent: " + userAgent);
        System.out.println("Host: " + host);

        return "home";
    }*/
}
/*
    @RequestMapping(method= RequestMethod.GET)
    public void getMethod(@RequestHeader("Test-Header") String value) {
        System.out.println("Test-Header=" + value);
    }*/

