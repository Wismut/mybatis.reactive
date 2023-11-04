package com.example.mybatis.reactive.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SizedResponse<T> {

    private final T data;

    private final Long count;
}
