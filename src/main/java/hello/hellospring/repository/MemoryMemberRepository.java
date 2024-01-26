package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

// 인터페이스 메소드 구현부
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static  Long sequence = 0L; // 회원 아이디 값


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
          return store.values().stream()
                  .filter(member -> member.getName().equals(name))
                  .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // store 초기화 코드
    public void clearStore(){
        store.clear();
    }
}
