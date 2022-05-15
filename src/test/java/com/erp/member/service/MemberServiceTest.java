package com.erp.member.service;

import com.erp.member.domain.Member;
import com.erp.member.domain.MemberRepository;
import com.erp.member.domain.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void save() {

        Member member = Member.builder()
                .id("pgw4712")
                .password("kwan1234")
                .name("박관우")
                .email("pgw4712@icloud.com")
                .phone("010-6319-4712")
                .role(Role.ROLE_STAFF)
                .build();

        memberRepository.save(member);
        Member savedMember = memberRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("일치하는 회원이 없습니다,."));
        assertThat(member).isEqualTo(savedMember);

    }
}