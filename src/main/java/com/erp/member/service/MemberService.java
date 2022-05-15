package com.erp.member.service;

import com.erp.member.controller.dto.MemberRequestDto;
import com.erp.member.domain.Member;
import com.erp.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public void save(MemberRequestDto memberRequestDto) {

        Member member = memberRequestDto.encodePassword(passwordEncoder).toMember();
        memberRepository.save(member);
    }

    public boolean checkMembersSignUpRequestValidation(MemberRequestDto memberRequestDto, Model model) {

        Map<String, String> errors = new HashMap<>();
        if (memberRepository.existsByEmail(memberRequestDto.getEmail())) {
            errors.put("emailError", "true");
        }

        model.addAttribute("errors", errors);
        return errors.isEmpty();
    }

    public Member findByEmail(String email) {

        return memberRepository.findByEmail(email).orElseThrow(() -> new CredentialsExpiredException("다시 로그인해주세요"));
    }
}
