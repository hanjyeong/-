package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {

        //given
        Member member= new Member();
        member.setName("오리너구리100");

        //when
       Long saveId= memberService.join(member);

        //then

        /*  <member의 정보가 repostory에 저장되었는지 검증하기>
         *   saveId로 repository를 조회한 결과와 member가 일치할 것*/

        //1. saveId로 repository 조회
        Member findMember= memberService.findOne(saveId).get();
        //2. 조회한 정보가 member와 일치하는지 확인하기
        System.out.println("Member: " + member);
        System.out.println("Find Member: " + findMember);
    }
    @Test
    public void 중복_회원_예외(){

        //given
        Member member1 = new Member();
        member1.setName("오리너구리");

        Member member2 = new Member();
        member2.setName("오리너구리");

        memberService.join(member1);

        //when : 예외상황 발생시
         /*()-> memberService.join(member2)이 로직이 수행되면,
        IllegalStateException이 실행되어야함*/

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));


        //then : 예외처리문이 잘 나오는지 확인하기
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름 입니다!!");
    }

}
