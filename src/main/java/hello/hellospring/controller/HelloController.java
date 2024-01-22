package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // hello 페이지 띄워주기
    @GetMapping("hello")
    public String hello(Model model){

         model.addAttribute("data","hello!!"); // model값 설정
         return "hello"; // template에서 hello.index파일을 찾아서 띄워줌
    }
}
