package com.back;

import com.back.domain.wiseSaying.entity.WiseSaying;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PageDto {

    private int pageNo;
    private int pageSize;
    private int totalItems;
    private List<WiseSaying> content;

    public int getTotalPageCnt() {
        if( totalItems == 0) return 0;
        return (int) Math.ceil((double) totalItems / (double) pageSize);
    }
}
