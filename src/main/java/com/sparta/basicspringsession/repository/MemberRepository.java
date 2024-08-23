package com.sparta.basicspringsession.repository;

import com.sparta.basicspringsession.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository 는 Interface 다.
public interface MemberRepository extends JpaRepository<Member, Long> {

}
