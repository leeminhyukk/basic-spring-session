package controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
}
