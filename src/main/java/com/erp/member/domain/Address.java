package com.erp.member.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Address {

    @NotBlank(message = "우편번호를 입력해주세요.")
    private String postcode;

    @NotBlank(message = "기본주소를 입력해주세요.")
    private String address;

    @NotBlank(message = "상세주소를 입력해주세요.")
    private String detailAddress;

    @NotBlank(message = "참고사항을 입력해주세요.")
    private String extraAddress;
}
