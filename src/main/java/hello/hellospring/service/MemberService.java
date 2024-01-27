package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memberRepository;

    // 외부에서 memberRepository의 값을 주입 받음 : 생성자 주입

    //MemberService의 생성자: 매개변수 Memberrepository 객체
    public MemberService(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join(Member member) {

        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {                       // 같은 이름이 존재하는 경우
                    throw new IllegalStateException("이미 존재하는 이름 입니다!!");
                });
    }


    // 전체 회원 조회
    public List<Member> findMembers() {

        return memberRepository.findAll();
    }

    // Service에서 repository 값을 찾을 수 있도록 메소드를 만듬
    public Optional<Member> findOne (Long memberId){

        return memberRepository.findById(memberId);
    }




}
