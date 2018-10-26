package edu.zju.sc.rxj;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class ExceptionHelperTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void constructException1() throws Exception {
        Throwable T = new IOException();
        String message = "IO异常";
        Throwable throwable = ExceptionHelper.constructException(T.getClass(),message);
        System.out.println(throwable.toString());
    }

    @Test
    public void constructException2() throws Exception {
        Throwable T = new IOException();
        String message = "IO异常";
        Throwable cause =T.getCause();
        Throwable throwable = ExceptionHelper.constructException(T.getClass(),message,cause);
        System.out.println("异常"+throwable.toString());
        System.out.println("异常信息:"+throwable.getMessage());
        System.out.println("异常原因:"+throwable.getCause());

    }
}