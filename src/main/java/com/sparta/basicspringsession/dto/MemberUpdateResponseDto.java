package com.sparta.basicspringsession.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberUpdateResponseDto {
    private final Long id;
    private final String name;


}
