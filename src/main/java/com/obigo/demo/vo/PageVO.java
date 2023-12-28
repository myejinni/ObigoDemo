package com.obigo.demo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVO {

    private int page; // 현재 페이지 번호
    private int perPageNum; // 페이지 당 출력 게시글 갯수

    // 1페이지, 10개로 지정해서 처리
    public PageVO() {
        this.page = 1;
        this.perPageNum = 10;
    }

    public void setPerPageNum(int perPageNum) {

        if (perPageNum <= 0 || perPageNum > 100){
            this.perPageNum = 10;
            return;
        }

        this.perPageNum = perPageNum;

    }

    public int getPageStart() {

        return (this.page-1) * perPageNum;

    }
}
