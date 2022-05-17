package com.erp.board.service;

import com.erp.board.controller.dto.BoardRequestDto;
import com.erp.board.controller.dto.BoardResponseDto;
import com.erp.board.domain.Board;
import com.erp.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import static org.springframework.data.domain.Sort.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardResponseDto> findAll() {
        List<Board> list = boardRepository.findAll(by(Order.desc("id")));
        List<BoardResponseDto> boards = list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
        return boards;
    }

    @Transactional(readOnly = true)
    public Page<BoardResponseDto> findAll(Pageable pageable) {
        Page<BoardResponseDto> boards = boardRepository.findAll(pageable).map(BoardResponseDto::new);
        return boards;
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
