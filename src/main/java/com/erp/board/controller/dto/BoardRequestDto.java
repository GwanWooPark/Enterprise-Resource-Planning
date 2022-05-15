package com.erp.board.controller.dto;

import com.erp.board.domain.Board;
import com.erp.board.domain.category.Category;
import com.erp.member.domain.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BoardRequestDto {

    private String title;
    private String content;
    private Category category;

    private Member member;

    public Board toBoard() {
        return Board.builder()
                .title(title)
                .content(content)
                .category(category)
                .build();
    }
}
