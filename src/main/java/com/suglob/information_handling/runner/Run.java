package com.suglob.information_handling.runner;

import com.suglob.information_handling.action.TextAction;
import com.suglob.information_handling.entity.Component;
import com.suglob.information_handling.entity.CompositeText;
import com.suglob.information_handling.entity.Lexeme;
import com.suglob.information_handling.parse.ParseFile;
import com.suglob.information_handling.parse.ParseText;

import java.util.ArrayList;


public class Run {
    public static final String FILENAME="src/main/resources/files/in.txt";

    public static void main(String[] args) {


        String text=ParseFile.parseTxt(FILENAME);
        ParseText parseText=new ParseText();
        CompositeText compositeText=parseText.parse(text);
        compositeText.print();
        System.out.println();

        TextAction.changeLexemesFirstLast(compositeText);
    }
}
