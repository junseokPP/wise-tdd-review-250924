package com.back.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilJsonTest {

    @Test
    @DisplayName("Map을 Json으로 바꿀 수 있다.")
    void t1() {
        // given

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", 1);
        map.put("name", "홍길동");
        map.put("age", 20);

        // when
        String jsonStr = Util.json.toString(map);

        // then
        assertThat(jsonStr).isEqualTo(
                """
                {
                    "id": 1,
                    "name": "홍길동",
                    "age": 20
                }"""
        );

    }

}