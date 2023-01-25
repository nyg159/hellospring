package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // hello로 라고 url에 있으면 리턴 값을 준다
    public String hello(Model model) {
        model.addAttribute("data" ,"hello!!");
        return "hello1";

    }

    @GetMapping("hello-mvc")  // return 으로 hello-template 파일로 리턴 해준다.
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }


    @GetMapping("hello-string")  // 이방식은 바로 return 으로 데이터만 보내준다 html 코드 하나 없이
    @ResponseBody
    public  String hellostring(@RequestParam("name") String name) {
        return "hello" + name;
    }


    @GetMapping("hello-api") // api 방식
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}