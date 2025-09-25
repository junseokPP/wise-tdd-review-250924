package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    Scanner sc;
    public WiseSayingController(Scanner sc) {
        this.sc = sc;
    }

    int lastId = 0;
    List<WiseSaying> wiseSayings = new ArrayList<>();


    public void actionAdd() {

        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        lastId++;
        WiseSaying wiseSaying = new WiseSaying(lastId, saying, author);
        wiseSayings.add(wiseSaying);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(lastId));
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        wiseSayings.reversed().stream()
                .forEach(wiseSaying -> System.out.println("%d / %s / %s"
                        .formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getSaying())));

    }
}
