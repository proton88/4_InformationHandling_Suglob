package com.suglob.information_handling.runner;

import com.suglob.information_handling.action.TextAction;
import com.suglob.information_handling.entity.CompositeText;
import com.suglob.information_handling.reader.ReadFile;
import com.suglob.information_handling.parse.ParseText;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Run {
    public static final String PROPERTY_FILE_LOG4J="src/main/resources/property/log4j.properties";
    public static final String FILENAME="src/main/resources/files/in.txt";
    public static final char SYMBOL='l';
    public static final int LEXEME_SIZE=4;

    static {
        PropertyConfigurator.configure(PROPERTY_FILE_LOG4J);
    }
    static Logger logger = Logger.getLogger(Run.class);

    public static void main(String[] args) {


        String text= ReadFile.parseTxt(FILENAME);
        ParseText parseText=new ParseText();
        CompositeText compositeText=parseText.parse(text);

        System.out.println(compositeText);

        System.out.println(TextAction.removeNextEqualsFirst(compositeText));

        System.out.println(TextAction.changeLexemesFirstLast(compositeText));

        System.out.println(TextAction.removeLexemes(compositeText,LEXEME_SIZE,SYMBOL));
    }
}
