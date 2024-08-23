package com.sparta.basicspringsession.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberDetailResponseDto {
    private final Long id;
    private final String name;
}
