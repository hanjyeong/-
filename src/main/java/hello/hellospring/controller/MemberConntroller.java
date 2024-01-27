package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberConntroller {

    public final MemberService memberService;

    @Autowired // 스프링 컨테이너에 있는 memberService의 값을 주입시켜줌
    public MemberConntroller(MemberService memberService){
        this.memberService=memberService;
    }

}
