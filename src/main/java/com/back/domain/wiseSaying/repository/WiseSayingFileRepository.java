package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.standard.util.Util;

import java.util.Map;
import java.util.Optional;

public class WiseSayingFileRepository {

    private static String dbPath = "db/wiseSaying/";

    public static void clear(){
        Util.file.delete(dbPath);
    }

    private String getFilePath(int id){
        return dbPath + "%d.json".formatted(id);
    }

    private String getLastIdPath(){
        return dbPath + "lastId.json";
    }

    public void save(WiseSaying wiseSaying) {

        if(wiseSaying.isNew()){
            incrementLatId();
            int lastId = getLastId();
            wiseSaying.setId(lastId);
            String jsonStr = Util.json.toString(wiseSaying.toMap());
            Util.file.set(getFilePath(lastId),jsonStr);

        }

    }

    private void incrementLatId() {

        Util.file.set(getLastIdPath(),String.valueOf(getLastId()+1));
    }

    private int getLastId() {

        return Util.file.getAsInt(getLastIdPath(),0);
    }

    public Optional<WiseSaying> findByIdOrNull(int id) {
        String json = Util.file.get(getFilePath(id),"");

        if(json.isEmpty()){
            return Optional.empty();
        }

        Map<String, Object> map = Util.json.toMap(json);
        WiseSaying wiseSaying = new WiseSaying(map);

        return Optional.of(wiseSaying);

    }

    public void delete(WiseSaying wiseSaying1) {

        Util.file.delete(getFilePath(wiseSaying1.getId()));

    }
}
