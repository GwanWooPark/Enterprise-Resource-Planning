package com.erp.img.domain;

import com.erp.board.domain.Board;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IMAGE_NO")
    private Long id;

    private String path;
    private String name;

    @ManyToOne(targetEntity = Board.class, fetch = LAZY)
    @JoinColumn(name = "BOARD_NO")
    private Board board;
}
