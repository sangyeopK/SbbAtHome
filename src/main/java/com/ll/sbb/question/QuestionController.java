package com.ll.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionRepository questionRepository;
    // final키를 붙여줘야된다고 했잖아 위에서 requiredArgsConstructor에서는 final 키를 가진 생성자로 생성해주는 의존성주입을 하는 그런거라서 final안붙이면 안됨
    @GetMapping("/question/list")
    public String list(Model model){
        List<Question> questionList = this.questionRepository.findAll();
        // DB에서 question에 대한 데이터를 가져와서 questionlist에 넣어준다
        model.addAttribute("questionList", questionList);
        //model은 기본적으로 뷰단에 뿌리기 위한 수단으로써 사용하는데 html에서 사용할 이름과, 실제로 받는 변수명 등을 순서대로 입력해주어야 한다.
        return "question_list";
    }
}
