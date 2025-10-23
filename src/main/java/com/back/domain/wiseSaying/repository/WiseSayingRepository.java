package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

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

    public List<WiseSaying> findByContentContainingDesc(String kw) {
        return wiseSayings.reversed().stream()
                .filter(w->w.getSaying().contains(kw))
                .limit(5)
                .toList();
    }

    public List<WiseSaying> findByAuthorContainingDesc(String kw) {

        return wiseSayings.reversed().stream()
                .filter(w->w.getAuthor().contains(kw))
                .limit(5)
                .toList();
    }

    public List<WiseSaying> findByAuthorContainingDescOrContentContainingDesc(String kw) {
        return wiseSayings.reversed().stream()
                .filter(w->w.getAuthor().contains(kw) || w.getSaying().contains(kw))
                .limit(5)
                .toList();

    }

    public boolean delete(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    public boolean modify(int id) {
        return false;
    }

    public WiseSaying findByIdOrNull(int id) {

        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst().orElse(null);
    }



}
