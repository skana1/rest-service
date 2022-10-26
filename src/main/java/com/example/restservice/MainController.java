package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
@RestController
public class MainController {

    private static final String template ="SpringAPI, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/main")
    @ResponseBody
    public Main sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Main(counter.incrementAndGet(), String.format(template, name));
    }

}
