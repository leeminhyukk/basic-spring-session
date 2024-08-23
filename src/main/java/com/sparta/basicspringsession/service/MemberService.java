package com.sparta.basicspringsession.service;


import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.repository.MemberRepository;
import com.sparta.basicspringsession.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //등록 ++ 읽기 Read 를 제외하면 @Transactional 붙이기.
    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto memberSaveRequestDto) {

        //멤버 객체를 새로 만드는 이유는 리턴해야하는 타입은 ID 와 이름 정보가 필요한데
        //멤버 객체를 만들 때, 이름만 넣어도 Id 값을 자동으로 생성해주기 때문.
        Member newMember = new Member(memberSaveRequestDto.getName());
        Member savedMember = memberRepository.save(newMember);
        // 만든 객체의 정보를 레포지토리에 담았고 그걸 savedMember 에 담았다.
        // service -> repository 라고 볼 수 있다.

        return new MemberSaveResponseDto(savedMember.getName());
        // 그렇게 생성된 savedMember 의 이름을 넣은 ResponseDto 를 반환.
    }

    //조회
    public List<MembersimpleResponseDto> getMembers(){
        // Member 타입의 리스트 인데 그 리스트는 레퍼지토리에서 모두 찾아온 리스트다.
        List<Member> members = memberRepository.findAll();

        List<MembersimpleResponseDto> dtoList = new ArrayList<>();
        for (Member member : members){
            MembersimpleResponseDto dto = new MembersimpleResponseDto(member.getId(),member.getName());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public MemberDetailResponseDto getMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NullPointerException("멤버가 없습니다."));

        return new MemberDetailResponseDto(member.getId(),member.getName());
    }

    @Transactional
    public MemberUpdateResponseDto UpdateMember(Long memberId, MemberUpdateRequestDto updateRequestDto) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NullPointerException("멤버가 없습니다."));

        member.update(updateRequestDto.getName());

        return new MemberUpdateResponseDto(member.getId(),member.getName());
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NullPointerException("멤버가 없습니다."));

        // 레퍼지토리에 따로 delete 라는 메서드를 만들지 않았지만 사용 가능했다.
        memberRepository.delete(member);

    }
}
