package com.bytespaces.JavaExceptionDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 如果要使用 try-resources的方式进行异常捕获和资源关闭， 需要实现AutoCloseable
 * @author shine
 */
public class helloDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("D:\\liuronghua\\IDEA_Code\\Practice_Code\\become-clever\\2022-interview-questions\\src\\main\\resources\\JavaFile_IO\\00be4177-675e-4102-8334-cf72f2abef90.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fife) {
            fife.printStackTrace();
        }
    }
}
