package com.erp.board.domain.category;

public enum Category {

    CATEGORY_NOTICE("공지사항"),
    CATEGORY_NORMAL("일반");

    private final String krDescription;


    public String getKrDescription() {
        return krDescription;
    }

    Category(String krDescription) {
        this.krDescription = krDescription;
    }
}
