package com.nhnacademy.springbootjpa.entity;

import com.nhnacademy.springbootjpa.repository.MemberRepository;
import com.nhnacademy.springbootjpa.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// TODO #2: test case
@DataJpaTest
class ManyToOneTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void test() {
        /// 현재 Member의 id가 autoincrease라서 flush 없이도 db에 save 쿼리를 보냄
        Member member = memberRepository.save(new Member("academy"));

        // 만약 post에 cascade = CascadeType.PERSIST를 부여하면
        // member를 save하지 않았었도 post에 해당 member 객체를 넣고 저장하면 member도 같이 먼저 저장된다.
        // Member member = new Member("academy");

        /// 현재 Post의 id가 autoincrease라서 flush 없이도 db에 save 쿼리를 보냄
        postRepository.save(new Post("제목 제목1", "내용 내용1", member));
        postRepository.save(new Post("제목 제목2", "내용 내용2", member));

        //entityManager.flush();
    }
}
