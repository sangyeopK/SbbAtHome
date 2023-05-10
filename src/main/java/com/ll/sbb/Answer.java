package com.ll.sbb;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    //private로 선언해야 하는이유는 getter, setter를 사용해서 처리를 하기때문에 이와같은 이유로 private로 엥간하면 선언해주어야 한다
    private Integer id;
    private String content;
    LocalDateTime createDate;
    // ManyToOne이 되는 이유는 Answer엔티티 기준으로 여러개가 하나의 질문에 들어가는 것이니
    // 관계를 생각할때는 엔티티명을 기준해라이
    @ManyToOne
    private Question question;
}
