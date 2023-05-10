package com.ll.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/main")
    public String main() {
        return "As";
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/question_list";
        // redirect사용하면 바로 mapping한 주소로 가고 그에 맞는 템플릿 보여줌
    }
}
