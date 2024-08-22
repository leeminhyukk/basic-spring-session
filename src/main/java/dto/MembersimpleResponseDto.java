package dto;

import lombok.AllArgsConstructor;

// 필드의 모든 내용을 생성자에서 메개변수로 받는다. 앞이 No 면 기본 생성자.
@AllArgsConstructor
public class MembersimpleResponseDto {
    private final Long id;
    private final String name;

}
