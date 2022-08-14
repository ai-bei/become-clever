package com.bytespaces.JavaExceptionDemo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.bytespaces.Java_IO_demo.TestOne.createFileReturnPath;
import static com.bytespaces.Java_IO_demo.TestOne.writeFileContent;

public class hello {

    public static void main(String[] args) {
        InputStream in = null;
        // init file
        String fileReturnPath = createFileReturnPath("");
        try{

            writeFileContent(fileReturnPath , "AAAAAAAA");
            writeFileContent(fileReturnPath , "BBBBBBBB");
            // start
            System.out.println("----- 使用传统的IO方式读取文件内容 -----");
            in = new BufferedInputStream(new FileInputStream(fileReturnPath));
            byte [] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while(bytesRead != -1)
            {
                for(int i=0;i<bytesRead;i++) {
                    System.out.print((char)buf[i]);
                }
                bytesRead = in.read(buf);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
