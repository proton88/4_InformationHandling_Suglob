package com.suglob.information_handling.reader;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Test;

public class ReadFileTest {
    public static final String PROPERTY_FILE_LOG4J="src/main/resources/property/log4j.properties";
    static {
        PropertyConfigurator.configure(PROPERTY_FILE_LOG4J);
    }
    static final Logger logger = Logger.getLogger(ReadFileTest.class);

    public static final String FILE="src/main/resources/files/in2.txt";
    public static final String FILE2="src/main/resources/files/in3.txt";
    public static final String TEST_STRING="Hello world!";

    @Test(expected = RuntimeException.class)
    public void readFileExceptionTest(){
        logger.info("Test readFileException is started");
        String actual= ReadFile.parseTxt(FILE);
        logger.info("Test readFileException is finished");
    }

    @Test
    public void readFileTest(){
        logger.info("Test readFile is started");
        String expected=TEST_STRING;
        String actual= ReadFile.parseTxt(FILE2);
        Assert.assertEquals(actual, expected);
        logger.info("Test readFile is finished");

    }
}
