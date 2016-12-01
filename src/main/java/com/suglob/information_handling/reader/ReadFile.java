package com.suglob.information_handling.reader;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {
    static Logger logger = Logger.getLogger(ReadFile.class);

    public static String parseTxt(String fileName){
        StringBuilder text=new StringBuilder();
        try (FileChannel fChan= (FileChannel)Files.newByteChannel(Paths.get(fileName))){
            long fileSize=fChan.size();
            MappedByteBuffer mBuf=fChan.map(FileChannel.MapMode.READ_ONLY,0,fileSize);
            for (int i=0;i<fileSize;i++){
                text.append((char)mBuf.get());
            }

        }catch (IOException e) {
            logger.fatal("Fail " + fileName + " is failed", e);
            throw new RuntimeException("Fail failed");
        }
        return text.toString();
    }
}
