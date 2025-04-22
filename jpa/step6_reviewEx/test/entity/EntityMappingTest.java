package com.nhnacademy.springbootjpa.entity;

import com.nhnacademy.springbootjpa.repository.AnswerRepository;
import com.nhnacademy.springbootjpa.repository.QuestionRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TODO #3: 아래 `@Disabled` 어노테이션을 삭제하고 테스트를 통과시키세요.
 */
//@Disabled("temporary")
@DataJpaTest
class EntityMappingTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Sql("entity-mapping-test.sql")
    @Test
    void test() {
        Question question1 = questionRepository.findById(1L).orElse(null);
        assertThat(question1).isNotNull();
        assertThat(question1.getId()).isEqualTo(1L);
        assertThat(question1.getTitle()).isEqualTo("질문입니다.");
        assertThat(question1.getContent()).isEqualTo("내용입니다.");
        assertThat(question1.getCreatedAt()).isEqualTo(ZonedDateTime.parse("2023-05-08T23:35:00Z"));

        Answer answer1 = answerRepository.findById(1L).orElse(null);
        assertThat(answer1).isNotNull();
        assertThat(answer1.getId()).isEqualTo(1L);
        assertThat(answer1.getQuestionId()).isEqualTo(1L);
        assertThat(answer1.getContent()).isEqualTo("답변입니다.");
        assertThat(answer1.getCreatedAt()).isEqualTo(ZonedDateTime.parse("2023-05-08T23:36:00Z"));

        Answer answer2 = answerRepository.findById(2L).orElse(null);
        assertThat(answer2).isNotNull();
        assertThat(answer2.getId()).isEqualTo(2L);
        assertThat(answer2.getQuestionId()).isEqualTo(1L);
        assertThat(answer2.getContent()).isEqualTo("또 다른 답변입니다.");
        assertThat(answer2.getCreatedAt()).isEqualTo(ZonedDateTime.parse("2023-05-08T23:36:30Z"));

        Answer answer3 = new Answer(1L, "또 또 답변", ZonedDateTime.now());
        answerRepository.save(answer3);
    }

}
