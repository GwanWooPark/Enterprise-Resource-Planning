package com.erp.member.service;

import com.erp.member.controller.dto.MemberSingUpDto;
import com.erp.member.domain.Address;
import com.erp.member.domain.Member;
import com.erp.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberSingUpDto memberSingUpDto) {

        Member member = memberSingUpDto.toMember();
        memberRepository.save(member);
    }
}
