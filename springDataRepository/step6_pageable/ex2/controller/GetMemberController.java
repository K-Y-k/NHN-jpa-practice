package com.nhnacademy.springbootjpa.controller;

import com.nhnacademy.springbootjpa.entity.MemberNameOnlyView;
import com.nhnacademy.springbootjpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetMemberController {

    private final MemberRepository memberRepository;


    // TODO #1: `GET /members?page=2&size=3` 와 같은 요청을 처리하도록 아래 코드를 완성하세요.
    @GetMapping("/members")
    public Page<MemberNameOnlyView> findAll(@PageableDefault(sort = {"name"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return memberRepository.readAllBy(pageable);
    }
}
