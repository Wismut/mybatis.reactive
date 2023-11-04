package com.example.mybatis.reactive.mapper;

import com.example.mybatis.reactive.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Mapper
public interface PersonMapper {
    Flux<Person> findAllByName(@Param("name") String name,
                               @Param("maxItems") Integer maxItems);

    Mono<Long> countByName(@Param("name") String name);
}
