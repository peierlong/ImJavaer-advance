package com.peierlong.nio.ifeve;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * 包名: com.peierlong.nio.ifeve
 * 创建人 : Elong
 * 时间: 10/03/2017 11:39 AM
 * 描述 : NIO读取文件示例
 */
public class ReadFileExample {
    public static void main(String[] args) throws IOException {
        //解决编码问题
        CharsetDecoder charsetDecoder = Charset.forName("utf-8").newDecoder();

        //打开一个Channel
        RandomAccessFile accessFile = new RandomAccessFile("/Users/elong/Downloads/3.公司相关/notes.txt", "rw");
        FileChannel readChannel = accessFile.getChannel();

        //缓冲区从通道中读取数据
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        int readSize = readChannel.read(byteBuffer);

        while (readSize != -1) {

            System.out.println("readSize : " + readSize);

            byteBuffer.flip();
            charsetDecoder.decode(byteBuffer, charBuffer, false);
            charBuffer.flip();


            while (charBuffer.hasRemaining()) {
                System.out.print(charBuffer.get());
            }

            byteBuffer.clear();
            charBuffer.clear();

            readSize = readChannel.read(byteBuffer);
        }
        accessFile.close();
    }
}