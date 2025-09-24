package com.back;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {
    public static String run(String input){
        Scanner sc = TestUtil.genScanner("종료");
        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();
        new App(sc).run();
        return outputStream.toString();
    }
}
