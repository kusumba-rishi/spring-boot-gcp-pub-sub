package com.projects147.google_pub_sub.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SampleController {

    @GetMapping("/greet")
    public String greet() {
        return "Hello";
    }

}
