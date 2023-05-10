package com.ll.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100)
    private String title;
   // @Column(text값 넣은건데 어노테이션 명을 모르겠어유)
    private String content;
    private LocalDateTime createDate;
    //answerList는 하나의 질문에 여러개가 달리는 OnetoMany이기 때문에 배열로 받아주는게 좋을듯하다
    // 그리고 자식으로 종속받는 경우에는 mappedBy라는 걸 주로 쓰는데 여기서는 부모의 entity명을 ""안에 써줘야한다.
    // cascade를 통해서 질문이 사라지면 답변도 같이 사라지도록 할거다 이때 사용하는 어노테이션은 cascade라고 한다잉
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}
