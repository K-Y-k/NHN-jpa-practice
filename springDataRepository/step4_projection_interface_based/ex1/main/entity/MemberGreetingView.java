package com.nhnacademy.springbootjpa.entity;

import org.springframework.beans.factory.annotation.Value;

// TODO #4: 열린 프로젝션을 위한 `MemberNameOnlyOpenView` 인터페이스
// target으로 전체를 가져오기 때문에 결국 프로젝션의 이점이 사라지므로 잘 사용하지 않는다.
public interface MemberGreetingView {
    @Value("#{'Hello, ' + target.name + '!'}")
    String getSalutation();
}
