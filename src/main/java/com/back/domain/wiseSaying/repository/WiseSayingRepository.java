package com.back.domain.wiseSaying.repository;

import com.back.PageDto;
import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingRepository {

    int lastId = 0;
    private List<WiseSaying> wiseSayings = new ArrayList<>();

    public WiseSaying save(WiseSaying wiseSaying) {
        if(wiseSaying.isNew()){
            wiseSaying.setId(++lastId);
            wiseSayings.add(wiseSaying);
        }

        return wiseSaying;
    }

    public PageDto findByContentContainingDesc(String kw,int pageSize,int pageNo) {
        List<WiseSaying> filteredItems =  wiseSayings.reversed().stream()
                .filter(w->w.getSaying().contains(kw))
                .toList();

        List<WiseSaying> content =  filteredItems.stream()
                .skip((pageNo-1)*pageSize)
                .limit(pageSize)
                .toList();

        int totalItems = filteredItems.size();

        return new PageDto(pageNo,pageSize,totalItems, content);
    }

    public PageDto findByAuthorContainingDesc(String kw,int pageSize,int pageNo) {

        List<WiseSaying> filteredItems =  wiseSayings.reversed().stream()
                .filter(w->w.getAuthor().contains(kw))
                .toList();

        List<WiseSaying> content =  filteredItems.stream()
                .skip((pageNo-1)*pageSize)
                .limit(pageSize)
                .toList();

        int totalItems = filteredItems.size();

        return new PageDto(pageNo,pageSize,totalItems, content);
    }

    public PageDto findByAuthorContainingDescOrContentContainingDesc(String kw,int pageSize,int pageNo) {

        List<WiseSaying> filteredItems =  wiseSayings.reversed().stream()
                .filter(w->w.getAuthor().contains(kw) || w.getSaying().contains(kw))
                .toList();

        List<WiseSaying> content =  filteredItems.stream()
                .skip((pageNo-1)*pageSize)
                .limit(pageSize)
                .toList();

        int totalItems = filteredItems.size();

        return new PageDto(pageNo,pageSize,totalItems, content);
    }

    public boolean delete(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    public boolean modify(int id) {
        return false;
    }

    public Optional<WiseSaying> findByIdOrNull(int id) {

        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst();
    }



}
