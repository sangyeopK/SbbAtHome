package com.ll.sbb.question;

import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionService questionService;
    // final키를 붙여줘야된다고 했잖아 위에서 requiredArgsConstructor에서는 final 키를 가진 생성자로 생성해주는 의존성주입을 하는 그런거라서 final안붙이면 안됨
    @GetMapping("/question/list")
    public String list(Model model){
        List<Question> questionList = this.questionService.getList();
        // DB에서 question에 대한 데이터를 가져와서 questionlist에 넣어준다
        model.addAttribute("questionList", questionList);
        //model은 기본적으로 뷰단에 뿌리기 위한 수단으로써 사용하는데 html에서 사용할 이름과, 실제로 받는 변수명 등을 순서대로 입력해주어야 한다.
        return "question_list";
    }

    @GetMapping(value = "/question/detail/{id}")
    // value값을 갖는 것들은 중괄호를 통해서 value를 집어 넣어야 함
    public String detail(Model model, @PathVariable("id") Integer id) {
        // pathvariable 어노테이션을 통해서 위의 값에 넣어줄 데이터를 선택해
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        // question_detail에서 찾아 쓸 question이라는 것.
        return "question_detail";
    }
}
