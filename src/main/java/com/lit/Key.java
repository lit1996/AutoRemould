package com.lit;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Key {

    static {
        try {
            Key.key = getKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String key;

    public static String getKey() {
        String str = new String();
        try (Scanner sc = new Scanner(new FileReader("src/main/resources/key"))) {
            while (sc.hasNextLine()) {  //按行读取字符串
                str += sc.nextLine();
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return str;
    }

    public static void setKey(String content) {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/key")) {
            fileWriter.append(content);
            key = content;
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
