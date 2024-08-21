package service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
}
