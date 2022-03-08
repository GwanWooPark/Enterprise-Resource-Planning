package com.erp.board.service;

import com.erp.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
}
