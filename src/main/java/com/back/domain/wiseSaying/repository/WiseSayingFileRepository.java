package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.standard.util.Util;

import java.util.Map;

public class WiseSayingFileRepository {
    public void save(WiseSaying wiseSaying) {

        if(wiseSaying.isNew()){
            incrementLatId();
            int lastId = getLastId();
            wiseSaying.setId(lastId);
            String jsonStr = Util.json.toString(wiseSaying.toMap());
            Util.file.set("db/wiseSaying/%d.json".formatted(wiseSaying.getId()),jsonStr);

        }

    }

    private void incrementLatId() {

        Util.file.set("db/wiseSaying/lastID.json",String.valueOf(getLastId()+1));
    }

    private int getLastId() {

        return Util.file.getAsInt("db/wiseSaying/lastID.json",0);
    }

    public WiseSaying findByIdOrNull(int id) {
        String json = Util.file.get("db/wiseSaying/%d.json".formatted(id),"");

        if(json.isEmpty()){
            return null;
        }

        Map<String, Object> map = Util.json.toMap(json);
        WiseSaying wiseSaying = new WiseSaying(map);

        return wiseSaying;

    }
}
