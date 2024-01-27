package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
// 시작 화면을 처리해주는 컨트롤러
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
