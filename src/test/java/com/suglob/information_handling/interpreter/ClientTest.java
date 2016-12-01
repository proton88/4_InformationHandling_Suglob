package com.suglob.information_handling.interpreter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Test;

public class ClientTest {
    public static final String PROPERTY_FILE_LOG4J="src/main/resources/property/log4j.properties";
    static {
        PropertyConfigurator.configure(PROPERTY_FILE_LOG4J);
    }
    static Logger logger = Logger.getLogger(ClientTest.class);

    public static final String TEST_STRING="6 9 3 4 - * +";

    @Test
    public void calculateTest(){
        logger.info("Test calculate is started");
        Double expected=-3.0;
        Client interpreter=new Client(TEST_STRING);
        Double actual= interpreter.calculate();
        Assert.assertEquals(actual, expected);
        logger.info("Test calculate is finished");
    }
}
