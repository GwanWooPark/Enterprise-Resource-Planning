package com.erp.member.domain;

import com.erp.common.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_NO")
    private Long id;

    private String email;
    private String password;

    private String name;

    private String phone;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Role role;
}
