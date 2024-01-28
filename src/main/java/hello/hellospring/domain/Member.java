package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity
public class Member {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increase
    private Long id;

    @Column
    private String name;


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
