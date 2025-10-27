package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.WiseSaying;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingFileRepositoryTest {

    WiseSayingFileRepository wiseSayingFileRepository;

    public WiseSayingFileRepositoryTest(){
        wiseSayingFileRepository = new WiseSayingFileRepository();
    }

    @BeforeEach
    public void beforeEach(){
        wiseSayingFileRepository.clear();
    }

    @AfterEach
    public void afterEach(){
        wiseSayingFileRepository.clear();
    }

    @Test
    @DisplayName("명언 파일 저장 테스트")
    void t1(){

        WiseSaying wiseSaying = new WiseSaying("적에게 내 죽음을 알리지마라.","이순신");

        wiseSayingFileRepository.save(wiseSaying);

        WiseSaying foundedWiseSaying = wiseSayingFileRepository.findByIdOrNull(1).get();

        assertThat(foundedWiseSaying).isEqualTo(wiseSaying);

    }

    @Test
    @DisplayName("명언 2개 파일 저장 테스트")
    void t2(){

        WiseSaying wiseSaying1 = new WiseSaying("적에게 내 죽음을 알리지마라.","이순신");
        WiseSaying wiseSaying2 = new WiseSaying("너 자신을 알라","소크라테스");

        wiseSayingFileRepository.save(wiseSaying1);
        wiseSayingFileRepository.save(wiseSaying2);

        WiseSaying foundedWiseSaying1 = wiseSayingFileRepository.findByIdOrNull(1).get();
        WiseSaying foundedWiseSaying2 = wiseSayingFileRepository.findByIdOrNull(2).get();

        assertThat(foundedWiseSaying1).isEqualTo(wiseSaying1);
        assertThat(foundedWiseSaying2).isEqualTo(wiseSaying2);

    }

    @Test
    @DisplayName("명언 1개 파일 삭제 테스트")
    void t3(){

        WiseSaying wiseSaying1 = new WiseSaying("적에게 내 죽음을 알리지마라.","이순신");

        wiseSayingFileRepository.save(wiseSaying1);

        wiseSayingFileRepository.delete(wiseSaying1);

        WiseSaying foundedWiseSaying1 = wiseSayingFileRepository.findByIdOrNull(1).orElse(null);

        assertThat(foundedWiseSaying1).isNull();

    }

}
