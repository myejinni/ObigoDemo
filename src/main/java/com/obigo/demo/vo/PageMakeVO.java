package com.obigo.demo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageMakeVO {

    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    private int displayPageNum = 10;

    private PageVO pageVO;

    public void setPageVO(PageVO pageVO){
        this.pageVO = pageVO;
    }

    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
        calcData();
    }

    private void calcData() {

        endPage = (int) (Math.ceil(pageVO.getPage() / (double) displayPageNum) * displayPageNum );

        startPage = (endPage - displayPageNum) + 1;

        prev = startPage == 1 ? false : true;

        next = endPage * pageVO.getPerPageNum() >= totalCount ? false : true;

    }

}
