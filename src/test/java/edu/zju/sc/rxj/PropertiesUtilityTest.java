package edu.zju.sc.rxj;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import static org.junit.Assert.*;

public class PropertiesUtilityTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getStringProperty() {
        Properties pro = new Properties();
        pro.put("key1", 1);//
        pro.put("key2", "ok");
        Exception exception = new IOException();
        boolean requried = true;
        try {
            String res1=PropertiesUtility.getStringProperty(pro, "key1", requried, exception.getClass());
            System.out.println("result1: "+res1);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            String res2=PropertiesUtility.getStringProperty(pro, "key2", requried, exception.getClass());
            System.out.println("result2: "+res2);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            String res3=PropertiesUtility.getStringProperty(pro, "key1", !requried, exception.getClass());
            System.out.println("result3: "+res3);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void getStringsProperty() {
        Properties pro = new Properties();
        pro.put("key1", 1);//
        pro.put("key2", "ok.love.you.!");
        Exception exception = new IOException();
        boolean requried = true;
        String delimiter = "\\.";
        try {
            String res1[]=PropertiesUtility.getStringsProperty(pro, "key1",delimiter, requried, exception.getClass());
            System.out.println("result1: "+res1);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            String res2[]=PropertiesUtility.getStringsProperty(pro, "key2", delimiter,requried, exception.getClass());
            System.out.println("result2: ");
            for (String str:res2
                 ) {
                System.out.print(str+" ");
            }
                System.out.println();

        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            String res3[]=PropertiesUtility.getStringsProperty(pro, "key1", delimiter,!requried, exception.getClass());
            System.out.println("result3: "+res3);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void getIntegerProperty() {
        Properties pro = new Properties();
        pro.put("key1", 1);//
        pro.put("key2", "ok");
        pro.put("key3", "1233");//
        Exception exception = new IOException();
        boolean requried = true;
        try {
            Integer res1=PropertiesUtility.getIntegerProperty(pro, "key1", requried, exception.getClass());
            System.out.println("result1: "+res1);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Integer res2=PropertiesUtility.getIntegerProperty(pro, "key2", requried, exception.getClass());
            System.out.println("result2: "+res2);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Integer res3=PropertiesUtility.getIntegerProperty(pro, "key1", !requried, exception.getClass());
            System.out.println("result3: "+res3);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Integer res4=PropertiesUtility.getIntegerProperty(pro, "key3", requried, exception.getClass());
            System.out.println("result4: "+res4);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void getLongProperty() {
        Properties pro = new Properties();
        pro.put("key1", 1);//
        pro.put("key2", "ok");
        pro.put("key3", "1233");//
        Exception exception = new IOException();
        boolean requried = true;
        try {
            Long res1=PropertiesUtility.getLongProperty(pro, "key1", requried, exception.getClass());
            System.out.println("result1: "+res1);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Long res2=PropertiesUtility.getLongProperty(pro, "key2", requried, exception.getClass());
            System.out.println("result2: "+res2);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Long res3=PropertiesUtility.getLongProperty(pro, "key1", !requried, exception.getClass());
            System.out.println("result3: "+res3);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Long res4=PropertiesUtility.getLongProperty(pro, "key3", requried, exception.getClass());
            System.out.println("result4: "+res4);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void getDoubleProperty() {
        Properties pro = new Properties();
        pro.put("key1", 1);//
        pro.put("key2", "ok");
        pro.put("key3", "1233.00");//
        pro.put("key4", "1233");//
        pro.put("key5", "00.01233a");//
        Exception exception = new IOException();
        boolean requried = true;
        try {
            Double res1=PropertiesUtility.getDoubleProperty(pro, "key1", requried, exception.getClass());
            System.out.println("result1: "+res1);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Double res2=PropertiesUtility.getDoubleProperty(pro, "key2", requried, exception.getClass());
            System.out.println("result2: "+res2);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Double res3=PropertiesUtility.getDoubleProperty(pro, "key1", !requried, exception.getClass());
            System.out.println("result3: "+res3);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Double res4=PropertiesUtility.getDoubleProperty(pro, "key3", requried, exception.getClass());
            System.out.println("result4: "+res4);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Double res5=PropertiesUtility.getDoubleProperty(pro, "key4", requried, exception.getClass());
            System.out.println("result5: "+res5);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Double res6=PropertiesUtility.getDoubleProperty(pro, "key5", requried, exception.getClass());
            System.out.println("result6: "+res6);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }

    }

    @Test
    public void getDateProperty() {
        Properties pro = new Properties();
        pro.put("key1", 1);//
        pro.put("key2", "ok");
        pro.put("key3", "2018-10-25 14:44:50");//
        Exception exception = new IOException();
        boolean requried = true;
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        try {
            Date res1=PropertiesUtility.getDateProperty(pro, "key1", strDateFormat,requried, exception.getClass());
            System.out.println("result1: "+res1);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Date res2=PropertiesUtility.getDateProperty(pro, "key2",strDateFormat, requried, exception.getClass());
            System.out.println("result2: "+res2);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Date res3=PropertiesUtility.getDateProperty(pro, "key1",strDateFormat, !requried, exception.getClass());
            System.out.println("result3: "+res3);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Date res4=PropertiesUtility.getDateProperty(pro, "key3",strDateFormat, requried, exception.getClass());
            System.out.println("result4: "+res4);
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }

    }

    @Test
    public void getClassProperty() {
        Properties pro = new Properties();
        pro.put("key1", 1);//
        pro.put("key2", "ok");
        pro.put("key3", "java.lang.String");//
        Exception exception = new IOException();
        boolean requried = true;
        try {
            Class<?> res1=PropertiesUtility.getClassProperty(pro, "key1", requried, exception.getClass());
            System.out.println("result1: "+res1.toString());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Class<?> res2=PropertiesUtility.getClassProperty(pro, "key2", requried, exception.getClass());
            System.out.println("result2: "+res2.toString());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Class<?> res3=PropertiesUtility.getClassProperty(pro, "key1", !requried, exception.getClass());
            System.out.println("result3: "+res3.toString());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            Class<?> res4=PropertiesUtility.getClassProperty(pro, "key3", requried, exception.getClass());
            System.out.println("result4: "+res4.toString());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }

    }

    @Test
    public void getSubConfiguration() {
        Properties pro = new Properties();
        pro.put("key1", 1);//
        pro.put("key2", "ok");
        pro.put("test.name", "小健");//
        pro.put("test.age", "23");//
        pro.put("test.gender", "male");//
        String prefix = "test";
        Properties result =PropertiesUtility.getSubConfiguration(pro,prefix);
        for (String key:result.stringPropertyNames()
             ) {
            System.out.println(key+" : "+result.get(key));

        }

    }
//    @Test
//    public void getPropertyTitle(){
//        String key = "pro";
//        PropertiesUtility.getPropertyTitle(key);
//    }
//
}