package com.nhnacademy.springbootjpa.entity;

import org.springframework.beans.factory.annotation.Value;

/// 열린 프로젝션을 위한 `MemberNameOnlyOpenView` 인터페이스
public interface MemberGreetingView {
    @Value("#{'Hello, ' + target.name + '!'}")
    String getSalutation();
}
