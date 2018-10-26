package edu.zju.sc.rxj;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Priority;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class Log4jUtilityTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void logEntrance() {
    org.apache.log4j.Logger logger1 = org.apache.log4j.Logger.getLogger("log1");
    org.apache.log4j.Logger logger2 = null;
    BasicConfigurator.configure();
    String signature = "Integer#toString";
    String paramNames1[] = {};
    String paramNames2[] = {"name", "age"};

    String paramValues1[] = {};
    String paramValues2[] = {"xiaojian", "23"};
    Log4jUtility.logEntrance(logger1, signature, paramNames1, paramValues1, Priority.DEBUG);
    Log4jUtility.logEntrance(logger2, signature, paramNames1, paramValues1, Priority.DEBUG);
    Log4jUtility.logEntrance(logger1, signature, paramNames2, paramValues2, Priority.DEBUG);


  }

  @Test
  public void logEntrance1() {
    org.apache.log4j.Logger logger1 = org.apache.log4j.Logger.getLogger("log1");
    org.apache.log4j.Logger logger2 = null;
    BasicConfigurator.configure();
    String signature = "Integer#toString";
    String paramNames1[] = {};
    String paramNames2[] = {"name", "age"};

    String paramValues1[] = {};
    String paramValues2[] = {"xiaojian", "23"};
    Log4jUtility.logEntrance(logger1, signature, paramNames1, paramValues1);
    Log4jUtility.logEntrance(logger2, signature, paramNames1, paramValues1);
    Log4jUtility.logEntrance(logger1, signature, paramNames2, paramValues2);

  }

  @Test
  public void logExit() {
    org.apache.log4j.Logger logger1 = org.apache.log4j.Logger.getLogger("log1");
    org.apache.log4j.Logger logger2 = null;
    BasicConfigurator.configure();
    String signature = "Integer#toString";
    Object value[] = {"ok"};
    Log4jUtility.logExit(logger1, signature, value);
    Log4jUtility.logExit(logger2, signature, value);
  }

  @Test
  public void logExit1() {
    org.apache.log4j.Logger logger1 = org.apache.log4j.Logger.getLogger("log1");
    org.apache.log4j.Logger logger2 = null;
    BasicConfigurator.configure();
    String signature = "Integer#toString";
    Object value[] = {"ok"};
    Log4jUtility.logExit(logger1, signature, value, new Date());
    Log4jUtility.logExit(logger2, signature, value, new Date());
  }

  @Test
  public void logExit2() {
    org.apache.log4j.Logger logger1 = org.apache.log4j.Logger.getLogger("log1");
    org.apache.log4j.Logger logger2 = null;
    BasicConfigurator.configure();
    String signature = "Integer#toString";
    Object value[] = {"ok"};
    Log4jUtility.logExit(logger1, signature, value, new Date(), Priority.DEBUG);
    Log4jUtility.logExit(logger2, signature, value, new Date(), Priority.DEBUG);
  }

  @Test
  public void logException() {
    org.apache.log4j.Logger logger1 = org.apache.log4j.Logger.getLogger("log1");
    org.apache.log4j.Logger logger2 = null;
    BasicConfigurator.configure();
    String signature = "Integer#toString";
    Exception exception = new IOException();
    Log4jUtility.logException(logger1, signature, exception);
    Log4jUtility.logException(logger2, signature, exception);
  }

  @Test
  public void logException1() {
    org.apache.log4j.Logger logger1 = org.apache.log4j.Logger.getLogger("log1");
    org.apache.log4j.Logger logger2 = null;
    BasicConfigurator.configure();
    String signature = "Integer#toString";
    Exception exception = new IOException();
    Log4jUtility.logException(logger1, signature, exception, Priority.DEBUG);
    Log4jUtility.logException(logger2, signature, exception, Priority.DEBUG);
  }
}