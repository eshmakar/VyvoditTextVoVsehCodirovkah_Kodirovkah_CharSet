package com.test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Codirovki {
    public static void main(String[] args) throws IOException {
//ВЫВОДИТЬ ТЕКСТ ВО ВСЕХ КОДИРОВКАХ
        while (true) {
            String text = new Scanner(System.in).nextLine();
            List<String> kodirovki = new LinkedList<>(Charset.availableCharsets().keySet());
            int count = 0, sovpadeniya = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < kodirovki.size(); i++) {
                count++;
                try {
                    String codirovTemp = kodirovki.get(i);
                    byte[] bytes = text.getBytes(codirovTemp);
                    String s = new String(bytes, codirovTemp);
                    if (text.equals(s)) {
                        sovpadeniya++;
                        sb.append(codirovTemp).append("\n");
                    }
                    System.out.printf("%-3d %-20s %s\n",count, codirovTemp,s);
                } catch (UnsupportedOperationException e) {
                }
            }
            System.out.println();
            System.out.printf("Кол-во совпадении: %d\n", sovpadeniya);
            System.out.printf("Список совпадении:\n");
            System.out.println(sb.toString());
            System.out.println();
        }
    }
}