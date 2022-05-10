package com.erp.member.controller;

import com.erp.member.controller.dto.MemberSingUpDto;
import com.erp.member.domain.Address;
import com.erp.member.domain.Member;
import com.erp.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
    public String signUp(@ModelAttribute(name = "member") MemberSingUpDto memberSingUpDto,
                         @ModelAttribute(name = "address") Address address) {
        return "member/signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid @ModelAttribute("member") MemberSingUpDto memberSingUpDto,
                         BindingResult bindingResult) {

        log.info("address = {}", memberSingUpDto.getAddress().getPostcode());
        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);
            return "member/signUp";
        }

        memberService.save(memberSingUpDto);
        return "redirect:/";
    }

}
