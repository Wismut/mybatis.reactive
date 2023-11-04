package com.example.mybatis.reactive.controller;

import com.example.mybatis.reactive.mapper.PersonMapper;
import com.example.mybatis.reactive.model.Person;
import com.example.mybatis.reactive.response.SizedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
@RestController("/persons")
public class PersonController {
    private final PersonMapper personMapper;

    @GetMapping("/")
    public Flux<Person> getPersons(String name) {
        return personMapper.findAllByName(name, null);
    }

    @GetMapping("/paged")
    public Mono<SizedResponse<List<Person>>> getPagedPersons(String name, Integer maxItems) {
        return Mono.zip(
                personMapper.findAllByName(name, maxItems).collectList(),
                personMapper.countByName(name)
        ).map(o -> new SizedResponse<>(o.getT1(), o.getT2()));
    }
}
