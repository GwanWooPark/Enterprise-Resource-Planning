package com.erp.member.controller;

import com.erp.member.controller.dto.MemberRequestDto;
import com.erp.member.domain.Address;
import com.erp.member.domain.Member;
import com.erp.member.service.MemberService;
import com.erp.security.service.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signUp")
    public String signUp(@ModelAttribute(name = "member") MemberRequestDto memberRequestDto,
                         @ModelAttribute(name = "address") Address address) {
        return "member/signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid @ModelAttribute("member") MemberRequestDto memberRequestDto,
                         BindingResult bindingResult,
                         Model model) {

        if (bindingResult.hasErrors()) {
            memberService.checkMembersSignUpRequestValidation(memberRequestDto, model);
            return "member/signUp";
        }

        if (!memberService.checkMembersSignUpRequestValidation(memberRequestDto, model)) {
            return "member/signUp";
        }

        memberService.save(memberRequestDto);
        return "redirect:/";
    }

    @GetMapping("/mypage")
    public String myPage(Authentication authentication, Model model) {


        if (authentication == null) {
            return "redirect:/login";
        }

        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        Member member = memberService.findByEmail(customUserDetails.getUsername());

        model.addAttribute("member", member);

        return "member/mypage";
    }
}
