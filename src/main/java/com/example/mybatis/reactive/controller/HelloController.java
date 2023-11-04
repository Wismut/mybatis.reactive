package com.example.mybatis.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
public class HelloController {

    @GetMapping("/")
    public Mono<String> hello(String name) {
        return Mono.just("Hello ".concat(Optional.ofNullable(name).orElse("World!")));
    }
}
