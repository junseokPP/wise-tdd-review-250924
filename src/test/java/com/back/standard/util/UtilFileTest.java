package com.back.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilFileTest {

    @Test
    @DisplayName("파일 생성")
    void t1(){

        //파일 경로 지정
        String filePath = "test.txt";

        //수행
        Util.file.touch(filePath);

        //존재여부
        boolean rst = Util.file.exists(filePath);
        assertThat(rst).isTrue();

    }

    @Test
    @DisplayName("파일삭제")
    void t2(){

        String filePath = "test.txt";
        Util.file.touch(filePath);

        Util.file.delete(filePath);

        boolean rst = Util.file.exists(filePath);
        assertThat(rst).isFalse();

    }
}
