package com.erp.board.domain;

import com.erp.board.domain.category.Category;
import com.erp.common.entity.BaseTimeEntity;
import com.erp.img.domain.Image;
import com.erp.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_NO")
    private Long id;
    private String title;

    @Column(length = 1000)
    private String content;

    // 이미지, 멤버
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_NO")
    private Member member;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
