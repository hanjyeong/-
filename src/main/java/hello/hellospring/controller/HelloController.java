package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!"); // model값 설정
         return "hello"; // template에서 hello.html파일을 찾아서 띄워줌
    }

    // MVC와 템플릿 엔진
    @GetMapping("hello-mvc")
    public String hellomvc(@RequestParam("name") String name,Model model){

             model.addAttribute("name",name);
             return "hello-template"; // hello-template.html

    }

    //API 방식 : @ResponseBody의 문자반환
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "안녕하세요!!" + name+ "님";

    }
    // @ResponseBody의 객체 반환
    @ResponseBody
    @GetMapping("/hello-api")
    public Hello helloapi(@RequestParam("name") String name){
        Hello hello= new Hello();
        hello.setName(name);

        return hello;
   }

   static class Hello{
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }
   }


}



