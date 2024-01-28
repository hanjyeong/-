package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
// 회원 가입과 회원 조회를 다루는 컨트롤러
    public final MemberService memberService;

    @Autowired // 스프링 컨테이너에 있는 memberService의 값을 주입시켜줌
    public MemberController(MemberService memberService){

        this.memberService=memberService;
    }

    //회원 가입 화면 띄워주기
    @GetMapping("/members/new")
    public String createForm(){
         return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){

        Member member= new Member();
        member.setName(form.getName());
        // 회원가입
        memberService.join(member);

        return "redirect:/"; // 홈 화면으로 돌아가기
    }

    // 회원 목록 조회
    @GetMapping("/members")
    public String list(Model model){

        // 회원 정보 조회
        List<Member> members = memberService.findMembers();
        // 받아온 데이터를 model객체로 변환하기
        model.addAttribute("members",members);

        return "members/memberList";
    }

}
