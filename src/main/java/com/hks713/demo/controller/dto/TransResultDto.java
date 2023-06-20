package com.hks713.demo.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TransResultDto {

    private final String name;
    private final int amount;
    private int status;
}
