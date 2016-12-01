package com.suglob.information_handling.action;

import com.suglob.information_handling.entity.CompositeText;
import com.suglob.information_handling.entity.Lexeme;
import com.suglob.information_handling.entity.TypeText;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TextActionTest {
    public static final String PROPERTY_FILE_LOG4J="src/main/resources/property/log4j.properties";
    static {
        PropertyConfigurator.configure(PROPERTY_FILE_LOG4J);
    }
    static Logger logger = Logger.getLogger(TextActionTest.class);

    private static CompositeText text;

    @BeforeClass
    public static void initActionText(){
        text=new CompositeText(TypeText.TEXT);
        CompositeText pharagraph=new CompositeText(TypeText.PHARAGRAPH);
        CompositeText sentence=new CompositeText(TypeText.SENTENCE);
        sentence.addTextElement(new Lexeme("It"));
        sentence.addTextElement(new Lexeme("is"));
        sentence.addTextElement(new Lexeme("leap"));
        sentence.addTextElement(new Lexeme("electronic"));
        sentence.addTextElement(new Lexeme("Ipsum."));
        pharagraph.addTextElement(sentence);
        text.addTextElement(pharagraph);
    }

    @Test
    public void removeNextEqualsFirstTest(){
        logger.info("Test removeNextEqualsFirst is started");
        String actual=TextAction.removeNextEqualsFirst(text).toString().trim();
        String expected="It is leap elctronic Ipsum.";
        boolean result=actual.equals(expected);
        Assert.assertTrue("Test failed: results is not equals", result);
        logger.info("Test removeNextEqualsFirst is finished");
    }

    @Test
    public void changeLexemesFirstLastTest(){
        logger.info("Test changeLexemesFirstLast is started");
        String actual=TextAction.changeLexemesFirstLast(text).toString().trim();
        String expected="Ipsum. is leap electronic It";
        Assert.assertEquals(expected,actual);
        logger.info("Test changeLexemesFirstLast is finished");
    }

    @Test
    public void removeLexemesTest(){
        logger.info("Test removeLexemes is started");
        String actual=TextAction.removeLexemes(text,4,'l').toString().trim();
        String expected="It is electronic Ipsum.";
        Assert.assertEquals(expected,actual);
        logger.info("Test removeLexemes is finished");
    }
}
