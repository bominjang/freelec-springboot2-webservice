package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor //선언된 모든 final 필드가 포함된 생성자를 생성해줌.
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){ //Model : 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음.
        model.addAttribute("posts", postsService.findAllDesc()); // postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달
        return "index";
        // Controller에서 문자열을 반환할 때, mustache starter가 앞에는 경로, 뒤에는 mustache 확장자를 붙여줌.
        //그러면 ViewResolver가 URL 요청의 결과를 전달할 타입과 값을 지정하면서 처리.
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
