package edu.zju.sc.rxj;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class LoggingUtilityHelperTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getMethodEntranceMessage() {
        String signature ="Integer#toString";
        System.out.println(LoggingUtilityHelper.getMethodEntranceMessage(signature));
    }


    @Test
    public void getInputParametersMessage() {
        String paramNames[]={"name","age","gender"};
        Object paramValues[]={"小健",22,"m"};
        System.out.println(LoggingUtilityHelper.getInputParametersMessage(paramNames,paramValues));
    }

    @Test
    public void getMethodExitMessage() {
        String signature ="Integer#toString";
        Date entranceTimestamp1 =new Date();
        Date entranceTimestamp2 =null;
        System.out.println(LoggingUtilityHelper.getMethodExitMessage(signature,entranceTimestamp1));
        System.out.println(LoggingUtilityHelper.getMethodExitMessage(signature,entranceTimestamp2));
    }

    @Test
    public void getOutputValueMessage() {
        Object  value = new Integer(3);
        System.out.println(LoggingUtilityHelper.getOutputValueMessage(value));

    }

    @Test
    public void getExceptionMessage() {
        String signature ="Integer#toString";
        Exception exception = new Exception();
        String result = LoggingUtilityHelper.getExceptionMessage(signature,exception);
        System.out.println(result);


    }
}