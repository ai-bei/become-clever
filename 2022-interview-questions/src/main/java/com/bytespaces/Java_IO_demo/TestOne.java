package com.bytespaces.Java_IO_demo;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.UUID;

public class TestOne {

    /**
     * 定义好创建存放文件的路径地址
     */
    private final static String TEST_ONE_PATH = "D:\\liuronghua\\IDEA_Code\\Practice_Code\\become-clever\\2022-interview-questions\\src\\main\\resources\\JavaFile_IO";
    private final static String DOT = ".";
    private final static String LEFT_SLASH = "/";



    /**
     * 案例1(对应传统io)是采用FileInputStream读取文件内容的：
     */
    @Test
    public void demoOne(){
        InputStream in = null;
        try{
            // init file
            String fileReturnPath = createFileReturnPath("");
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

    /**
     * 案例是对应的NIO（这里通过RandomAccessFile进行操作，当然也可以通过FileInputStream.getChannel()进行操作）：
     */
    @Test
    public void demoTwo(){
        RandomAccessFile aFile = null;
        try{
            // init file
            String fileReturnPath = createFileReturnPath("");
            writeFileContent(fileReturnPath , "AAAAAAAA");
            writeFileContent(fileReturnPath , "BBBBBBBB");
            writeFileContent(fileReturnPath , "CCCCCCCC");
            writeFileContent(fileReturnPath , "DDDDDDDD");
            // start
            System.out.println("----- 使用NIO方式读取文件内容 -----");
            aFile = new RandomAccessFile(fileReturnPath,"rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);
            while(bytesRead != -1)
            {
                buf.flip();
                while(buf.hasRemaining())
                {
                    System.out.print((char)buf.get());
                }
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile != null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    /**
     * 向文件中写入内容
     * @param filepath 文件路径与名称
     * @param newstr  写入的内容
     * @return boolean
     * @throws IOException
     */
    public static boolean writeFileContent(String filepath,String newstr) throws IOException{
        boolean bool = false;
        String filein = newstr+"\r\n";//新写入的行，换行
        String temp  = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//文件路径(包括文件名称)
            //将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();

            //文件原有内容
            for(int i=0;(temp =br.readLine())!=null;i++){
                buffer.append(temp);
                // 行与行之间的分隔符 相当于“\n”
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            //不要忘记关闭
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return bool;
    }


    /**
     * Files的常用方法都有哪些？
     *      exists()：检测文件路径是否存在。
     *      createFile()：创建文件。
     *      createDirectory()：创建文件夹。
     *      delete()：删除一个文件或目录。
     *      copy()：复制文件。
     *      move()：移动文件。
     *      size()：查看文件个数。
     *      read()：读取文件。
     *      write()：写入文件。
     */
    @Test
    public static void createFile(){
        File f = new File(getFilePath("txt"));
        try{
            //当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。
            boolean newFile = f.createNewFile();
            //返回由此抽象路径名表示的文件或目录的名称。
            System.out.println("该分区大小"+f.getTotalSpace()/(1024*1024*1024)+"G");
            //创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
            boolean mkdirs = f.mkdirs();
            //  删除此抽象路径名表示的文件或目录
            //f.delete();
            //  返回由此抽象路径名表示的文件或目录的名称。
            System.out.println("文件名  "+f.getName());
            // 返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。
            System.out.println("文件父目录字符串 "+f.getParent());

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 返回文件全路径
     * @return
     */
    public static String createFileReturnPath(String fileSufFix){
        String path = getFilePath(StringUtils.isBlank(fileSufFix) ? "txt" : fileSufFix );
        File f = new File(path);
        try{
            //当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。
            boolean newFile = f.createNewFile();
            //返回由此抽象路径名表示的文件或目录的名称。
            System.out.println("该分区大小: "+f.getTotalSpace()/(1024*1024*1024)+"G");
            //创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
//            boolean mkdirs = f.mkdirs();
            //  删除此抽象路径名表示的文件或目录
            //f.delete();
            //  返回由此抽象路径名表示的文件或目录的名称。
            System.out.println("文件名  "+f.getName());
            // 返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。
            System.out.println("文件父目录字符串 "+f.getParent());

        }catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 根据文件后缀类型，获取一个随机文件的全路径地址
     * @param fileSufFix 文件后缀
     * @return path
     */
    private static String getFilePath(String fileSufFix){
        return TEST_ONE_PATH + LEFT_SLASH +  fileName(fileSufFix);
    }

    /**
     * 根据后缀名称获取一个随机的文件名称
     * @param fileSufFix 文件后缀
     * @return file name
     */
    private static String fileName(String fileSufFix){
        String uuidStr = UUID.randomUUID().toString();
        return uuidStr + DOT + fileSufFix;
    }

    @Test
    public void getJavaClassPath() {
        TestOne testOne = new TestOne();
        testOne.one();
    }

    /**
     * JAVA获取CLASSPATH路径
     */
    public void one(){
        URL resource = this.getClass().getClassLoader().getResource("");
        URL resourceA = this.getClass().getResource("/");
        URL resourceB = this.getClass().getClassLoader().getResource("");
        URL resourceC = Thread.currentThread().getContextClassLoader().getResource("");
        URL systemResource = ClassLoader.getSystemResource("");
        System.out.println(resource.getPath());
        System.out.println(resourceA.getPath());
        System.out.println(resourceB.getPath());
        System.out.println(resourceC.getPath());
        System.out.println(systemResource.getPath());
    }
}
