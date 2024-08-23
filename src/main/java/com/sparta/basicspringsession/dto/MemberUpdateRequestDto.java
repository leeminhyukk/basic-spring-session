package com.sparta.basicspringsession.dto;

import lombok.Getter;

// 요청사항에는 입력된 값을 가져와야 하니 Getter ! 아이디는 자동으로 생성되니 이름만! 입력!
@Getter
public class MemberUpdateRequestDto {
    private String name;
}
