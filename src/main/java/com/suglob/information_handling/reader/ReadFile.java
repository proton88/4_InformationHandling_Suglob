package com.suglob.information_handling.reader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class ReadFile {
    public static String parseTxt(String fileName){
        StringBuilder text=new StringBuilder();
        int i;
        try (InputStream fin = Files.newInputStream(Paths.get(fileName)))
        {
            do {
                i = fin.read();
                if(i != -1) {
                    text.append((char) i);
                }

            } while(i != -1);

        } catch(InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        } catch(IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
        return text.toString();
    }
}
