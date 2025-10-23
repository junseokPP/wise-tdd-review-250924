package com.back;

import com.back.domain.wiseSaying.controller.WiseSayingController;
import com.back.system.SystemController;

import java.util.Scanner;

public class App {

    private Scanner sc;

    private WiseSayingController wiseSayingController;
    private SystemController systemController;

    public App() {
        this.sc = AppContext.sc;

        wiseSayingController = AppContext.wiseSayingController;
        systemController = AppContext.systemController;
    }
    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            Rq rq = new Rq(cmd);
            String actionName = rq.getActionName();

            switch (actionName) {
                case "등록" -> wiseSayingController.actionAdd();
                case "목록" -> wiseSayingController.actionList();
                case "삭제" -> wiseSayingController.actionDelete(rq);
                case "종료" ->{
                    systemController.actionExit();
                    return;
                }
            }
        }
    }

}