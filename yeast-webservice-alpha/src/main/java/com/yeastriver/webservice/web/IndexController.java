package com.yeastriver.webservice.web;

import com.yeastriver.webservice.config.auth.LoginUser;
import com.yeastriver.webservice.config.auth.dto.SessionUser;
import com.yeastriver.webservice.service.posts.PostsService;
import com.yeastriver.webservice.web.dto.PostsResponseDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("posts", postsService.findAllDesc());
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//        if (user != null) {
//            model.addAttribute("userName", user.getName());
//        }
//        return "index";
//    }

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(
            @PathVariable Long id,
            Model model
    ) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
