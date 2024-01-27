package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    // 스프링 빈 직접 코드로 등록하기
  @Bean
  public MemberService memberService(){
      return new MemberService(memberRepository());
  }
  @Bean
    public MemberRepository memberRepository(){
      return new MemoryMemberRepository();
  }

}