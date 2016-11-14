package com.suglob.information_handling.reader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class ReadFile {
    public static String parseTxt(String fileName){
        StringBuilder text=new StringBuilder();
        try (FileChannel fChan= (FileChannel)Files.newByteChannel(Paths.get(fileName))){
            long fileSize=fChan.size();
            MappedByteBuffer mBuf=fChan.map(FileChannel.MapMode.READ_ONLY,0,fileSize);
            for (int i=0;i<fileSize;i++){
                text.append((char)mBuf.get());
            }

        } catch (InvalidPathException e){
            System.out.println("Path error: " + e);
        }catch (IOException e) {
            System.out.println("IO Error"+e);
        }
        return text.toString();
    }
}
