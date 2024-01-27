package hello.hellospring.controller;

public class MemberForm {

    private String name; // 화면에서 입력한 이름이 name에 저장됨

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
