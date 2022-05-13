package com.erp.member.controller.dto;

import com.erp.member.domain.Address;
import com.erp.member.domain.Member;
import com.erp.member.domain.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberInfoDto {

    private String email;
    private String name;

    private String phone;
    private Address address;
    private Role role;

    public Member toMember() {
        return Member.builder()
                .email(email)
                .name(name)
                .phone(phone)
                .address(address)
                .role(role)
                .build();
    }
}
