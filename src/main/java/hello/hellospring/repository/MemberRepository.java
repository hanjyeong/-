package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member member);                // 회원 저장
    Optional<Member> findById(Long id);       // 아이디로 회원 찾기
    Optional<Member> findByName(String id);   //이름으로 회원 찾기
    List<Member> findAll();                  // 모든 회원의 정보 가져오기
}
