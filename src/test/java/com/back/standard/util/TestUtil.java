package com.back.standard.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class TestUtil {

    private static PrintStream ORIGINAL_OUT = System.out;//모니터
    private static PrintStream CURRENT_OUT = System.out;//모니터

    public static Scanner genScanner(String input) {
        return new Scanner(input);
    }

    public static ByteArrayOutputStream setOutToByteArray() {

        ORIGINAL_OUT = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); //ByteArrayOutputStream이안에 출력저장하는 공간 (메모리버퍼)
        PrintStream printStream = new PrintStream(outputStream); //빨대 역할
        System.setOut(printStream); //내가 지정한곳으로 보내.
        CURRENT_OUT = printStream;

        return outputStream;

    }

    public static void clearSetOutToByteArray(ByteArrayOutputStream outputStream) throws IOException {
        System.setOut(ORIGINAL_OUT);
        outputStream.close();
        CURRENT_OUT.close();
    }
}