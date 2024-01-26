package hello.hellospring.domain;

public class Member {
    //회원 엔티티
    private String name;
    private Long id;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
