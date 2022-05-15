package com.erp.board.service;

import com.erp.board.controller.dto.BoardRequestDto;
import com.erp.board.controller.dto.BoardResponseDto;
import com.erp.board.domain.Board;
import com.erp.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import static org.springframework.data.domain.Sort.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> findAll() {
        return boardRepository.findAll(by(Order.desc("createdTime")));
    }

    @Transactional(readOnly = true)
    public BoardResponseDto findById(Long boardId) {

        Board findBoard = boardRepository.findById(boardId)
                .orElseThrow(() ->
                        new IllegalArgumentException("해당 게시글이 없습니다"));

        return new BoardResponseDto(findBoard);
    }

    @Transactional
    public Long save(BoardRequestDto boardRequestDto) {
        return boardRepository.save(boardRequestDto.toBoard()).getId();
    }
}
