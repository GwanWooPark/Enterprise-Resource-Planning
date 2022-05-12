package com.erp.member.service;

import com.erp.member.controller.dto.MemberSingUpDto;
import com.erp.member.domain.Address;
import com.erp.member.domain.Member;
import com.erp.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public void save(MemberSingUpDto memberSingUpDto) {

        Member member = memberSingUpDto.encodePassword(passwordEncoder).toMember();
        memberRepository.save(member);
    }

    public boolean checkMembersSignUpRequestValidation(MemberSingUpDto memberSingUpDto, Model model) {

        Map<String, String> errors = new HashMap<>();
        if (memberRepository.existsByEmail(memberSingUpDto.getEmail())) {
            errors.put("emailError", "true");
        }

        model.addAttribute("errors", errors);
        return errors.isEmpty();
    }


}
