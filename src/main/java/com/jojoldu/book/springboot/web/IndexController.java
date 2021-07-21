package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor //선언된 모든 final 필드가 포함된 생성자를 생성해줌.
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        //Model : 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음. + 어느 컨트롤러든 @LoginUser만 추가하면 세션 정보를 가져올 수 있게 됨.
        model.addAttribute("posts", postsService.findAllDesc()); // postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달

        if(user!=null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
        // Controller에서 문자열을 반환할 때, mustache starter가 앞에는 경로, 뒤에는 mustache 확장자를 붙여줌.
        //그러면 ViewResolver가 URL 요청의 결과를 전달할 타입과 값을 지정하면서 처리.
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
