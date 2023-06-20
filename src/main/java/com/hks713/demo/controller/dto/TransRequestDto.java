package com.hks713.demo.controller.dto;

import com.hks713.demo.domain.core.Header;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TransRequestDto {

    private final String name;
    private final int amount;

    private final Header header;
}
