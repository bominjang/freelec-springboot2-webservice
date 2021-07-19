package com.jojoldu.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
        // Controller에서 문자열을 반환할 때, mustache starter가 앞에는 경로, 뒤에는 mustache 확장자를 붙여줌.
        //그러면 ViewResolver가 URL 요청의 결과를 전달할 타입과 값을 지정하면서 처리.
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
