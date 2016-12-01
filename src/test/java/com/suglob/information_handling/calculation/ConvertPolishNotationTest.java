package com.suglob.information_handling.calculation;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Test;

public class ConvertPolishNotationTest {
    public static final String PROPERTY_FILE_LOG4J="src/main/resources/property/log4j.properties";
    static {
        PropertyConfigurator.configure(PROPERTY_FILE_LOG4J);
    }
    static Logger logger = Logger.getLogger(ConvertPolishNotationTest.class);

    public static final String TEST_STRING="6+9*(3-4)";
    public static final String RESULT_STRING="6 9 3 4 - * +";

    @Test
    public void sortingStationTest(){
        logger.info("Test sortingStation is started");
        String expected=RESULT_STRING;
        String actual=ConvertPolishNotation.sortingStation(TEST_STRING);
        Assert.assertEquals(actual, expected);
        logger.info("Test sortingStation is finished");
    }
}
