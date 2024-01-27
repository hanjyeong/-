package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {

   MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각각의 메소드 수행이 끝난후 repository 초기화
    @AfterEach
    public void afterEach(){
         repository.clearStore();
    }

    // save 메소드 테스트
    @Test
    public void save(){

        // 임의의 값 설정
        Member member = new Member();
        member.setName("오리너구리");
        repository.save(member);

        // 저장한 이름과 가져온 이름이 같은지 확인하기
        Member result= repository.findById(member.getId()).get();
        Assertions.assertThat(result).isEqualTo(member);

        /*
          1. System.out.println(" result = "+(result==member));
          2. Assertions.assertEquals(member,result);
          3. Assertions.asserThat(member).isEqualTo(result);
        */


    }

    // findByName 메소드 테스트
    @Test
    public void findByName(){

        // 임의의 값 설정하기
        Member member1= new Member();
        member1.setName("오리너구리1");
        repository.save(member1);

        Member member2= new Member();
        member2.setName("오리너구리2");
        repository.save(member2);

        // findByName메소드 테스트 해보기

        Member result= repository.findByName("오리너구리2").get();
        assertThat(result).isEqualTo(member2);
        // Optional<Member> result= repository.findByName("오리너구리1);

    }

    //findAll메소드 테스트
    @Test
    public void findAll(){

        Member member1= new Member();
        member1.setName("오리너구리1");
        repository.save(member1);

        Member member2= new Member();
        member2.setName("오리너구리2");
        repository.save(member2);

        List<Member> result= repository.findAll();
        assertThat(result.size()).isEqualTo(2);


    }

}
