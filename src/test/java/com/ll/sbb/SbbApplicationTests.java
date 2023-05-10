package com.ll.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SbbApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	// 생성자 getter나 setter같은걸 사용할때 붙여줘야지 인스턴스가 자동으로 주입
	private AnswerRepository answerRepository;

	@Test
	void testJpa() {
		Question q1 = new Question();
		q1.setTitle("제목2");
		q1.setContent("내용2");
		q1.setCreateDate(LocalDateTime.now());
		//데이터를 다 넣었다 그런데 저장을 하려면 어디에 해야할까
		// Jpa를 상속받은 repository에 save메소드가 있는 것 같애유
		questionRepository.save(q1);
		// ===========질문1 저장 끝===========

		Answer a1 = new Answer();
		a1.setContent("1번댓글");
		a1.setQuestion(q1);
		a1.setCreateDate(LocalDateTime.now());
		answerRepository.save(a1);
	}

}
