package com.back.domain.wiseSaying.service;

import com.back.AppContext;
import com.back.PageDto;
import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {

    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingService(){
        this.wiseSayingRepository = AppContext.wiseSayingRepository;
    }

    public WiseSaying write(String saying, String author) {
        WiseSaying wiseSaying = new WiseSaying(saying, author);
        wiseSayingRepository.save(wiseSaying);
        return wiseSaying;
    }

    public PageDto findListDesc(String kw, String kwType, int pageNo, int pageSize) {
        if(kwType.equals("content")){
            return wiseSayingRepository.findByContentContainingDesc(kw,pageNo,pageSize);
        }else if(kwType.equals("author")) {
            return wiseSayingRepository.findByAuthorContainingDesc(kw,pageNo,pageSize);
        }else{
            return wiseSayingRepository.findByAuthorContainingDescOrContentContainingDesc(kw,pageNo,pageSize);
        }
    }

    public boolean delete(int id) {
        return wiseSayingRepository.delete(id);
    }

    public WiseSaying findByIdOrNull(int id) {
        return wiseSayingRepository.findByIdOrNull(id);

    }

    public void modify(WiseSaying wiseSaying, String newSaying, String newAuthor) {
        wiseSaying.setSaying(newSaying);
        wiseSaying.setAuthor(newAuthor);

        wiseSayingRepository.save(wiseSaying);
    }
}
