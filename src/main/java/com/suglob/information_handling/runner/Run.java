package com.suglob.information_handling.runner;

import com.suglob.information_handling.action.TextAction;
import com.suglob.information_handling.entity.CompositeText;
import com.suglob.information_handling.reader.ReadFile;
import com.suglob.information_handling.parse.ParseText;



public class Run {
    public static final String FILENAME="src/main/resources/files/in.txt";
    public static final char SYMBOL='l';
    public static final int LEXEME_SIZE=4;

    public static void main(String[] args) {


        String text= ReadFile.parseTxt(FILENAME);
        ParseText parseText=new ParseText();
        CompositeText compositeText=parseText.parse(text);

        System.out.println(compositeText);

        TextAction.removeNextEqualsFirst(compositeText);

        TextAction.changeLexemesFirstLast(compositeText);

        TextAction.removeLexemes(compositeText,LEXEME_SIZE,SYMBOL);
    }
}
