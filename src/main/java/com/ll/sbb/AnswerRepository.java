package com.ll.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

//Jpa레포지토리를 상속받아서 JPA로서의 역할을 부여했다
// 그리고 answer와 integer로 아이디와 답변에 대한 데이터를 처리히려고 요로코롬 만들어뒀다
// interface로 처리한 이유에 대해 질문해야겠다 모르겠다
public interface AnswerRepository extends JpaRepository<Answer, Integer>{

}
