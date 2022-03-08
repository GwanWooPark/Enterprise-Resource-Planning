package com.erp.board.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String title;
    private String content;

    // 이미지, 멤버, 날짜, 카테고리
}
