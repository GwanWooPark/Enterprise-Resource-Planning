package com.erp.board.controller.dto;

import com.erp.board.domain.Board;
import com.erp.board.domain.category.Category;
import com.erp.member.domain.Member;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class BoardResponseDto {

    private final Long no;
    private final Member member;
    private final String title;
    private final String content;
    private final Category category;
    private final String createDate;
    private final String modifiedDate;


    public BoardResponseDto(Board board) {
        no = board.getId();
        member = board.getMember();
        title = board.getTitle();
        content = board.getContent();
        category = board.getCategory();
        createDate = toStringDateTime(board.getCreatedTime());
        modifiedDate = toStringDateTime(board.getLastModifiedDate());

    }

    private static String toStringDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
