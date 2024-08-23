package com.sparta.basicspringsession.controller;

import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 등록
    @PostMapping("/members")
    public ResponseEntity<MemberSaveResponseDto> saveMember(@RequestBody MemberSaveRequestDto memberSaveRequestDto){
        return ResponseEntity.ok(memberService.saveMember(memberSaveRequestDto));
        // 객체만들고, savaMember 메서드 적용하고, 그렇게 생성된 Dto 리턴.
        // controller -> service -> repository -> service -> controller -> client 구조 때문
        // 중 controller -> service 라고 볼 수 있다.
    }

    // 전체 조회
    @GetMapping("/members")
    public ResponseEntity<List<MembersimpleResponseDto>> getMembers(){
        return ResponseEntity.ok(memberService.getMembers());
    }

    // Id 검색 조회
    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberDetailResponseDto> getMember(@PathVariable Long memberId){
        // 경로에 Id 값이 들어가서 메서드 메개변수에 @PathVariable 을 붙여준다.
        return ResponseEntity.ok(memberService.getMember(memberId));
    }

    // 수정
    @PutMapping("/members/{memberId}")
    public ResponseEntity<MemberUpdateResponseDto> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto updateRequestDto){
        // 객체에 Id, name 수정 = memberService.UpdateMember(memberId,updateRequestDto);
        // 객체 반환 타입 변경해 주는것 = ResponseEntity.ok()
        // 즉 수정된 내용을 타입을 변경해서 반환해주면 아래와 같은 모양!
        return ResponseEntity.ok(memberService.UpdateMember(memberId,updateRequestDto));
    }

    //삭제
    @DeleteMapping("/members/{memberId}")
    public void deleteMember(@PathVariable Long memberId){
        memberService.deleteMember(memberId);
    }


}
