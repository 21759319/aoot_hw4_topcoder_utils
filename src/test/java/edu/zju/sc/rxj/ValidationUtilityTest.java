package edu.zju.sc.rxj;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ValidationUtilityTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void checkNotNull() {
        Object value1 = null;
        Object value2 = "ok";

        String name = "value";
        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotNull(value1, name, exception.getClass());
            ValidationUtility.checkNotNull(value2, name, exception.getClass());

        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }

    }

    @Test
    public void checkNotEmpty() {
        String value = "";
        String name = "value";
        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotEmpty(value, name, exception.getClass());

        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }

    }

    @Test
    public void checkNotEmptyAfterTrimming() {
        String value = " ";
        String name = "value";
        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotEmptyAfterTrimming(value, name, exception.getClass());

        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotNullNorEmpty() {
        String value1 = null;
        String value2 = "";
        String value3 = "ok";
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";
        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotNullNorEmpty(value1, name1, exception.getClass());

        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNullNorEmpty(value2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNullNorEmpty(value3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotNullNorEmptyAfterTrimming() {
        String value1 = null;
        String value2 = " ";
        String value3 = " ok ";
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";
        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotNullNorEmptyAfterTrimming(value1, name1, exception.getClass());

        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNullNorEmptyAfterTrimming(value2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNullNorEmptyAfterTrimming(value3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkInstance() {
        String value1 = null;
        String value2 = " ok ";
        Integer value3 = 1;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";
        Exception exception = new IOException();
        try {
            ValidationUtility.checkInstance(value1, name1.getClass(), name1, exception.getClass());

        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInstance(value2, name2.getClass(), name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInstance(value3, name3.getClass(), name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNullOrInstance() {
        String value1 = null;
        String value2 = " ok ";
        Integer value3 = 1;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";

        Exception exception = new IOException();
        try {
            ValidationUtility.checkNullOrInstance(value1, name1.getClass(), name1, exception.getClass());

        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNullOrInstance(value2, name2.getClass(), name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNullOrInstance(value3, name3.getClass(), name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkExists() {
        File file1 = new File("./1.txt");
        File file2 = null;
        File file3 = new File("./2.txt");

        String name1 = "file1";
        String name2 = "file2";
        String name3 = "file3";
        Exception exception = new IOException();

//        System.out.println(file1.toString());
        try {
            ValidationUtility.checkExists(file1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkExists(file2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkExists(file3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkIsFile() {
        File file1 = new File("./1.txt");
        File file2 = null;
        File file3 = new File("./");

        String name1 = "file1";
        String name2 = "file2";
        String name3 = "file3";
        Exception exception = new IOException();

//        System.out.println(file1.toString());
        try {
            ValidationUtility.checkIsFile(file1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkIsFile(file2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkIsFile(file3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkIsDirectory() {
        File file1 = new File("./1.txt");
        File file2 = null;
        File file3 = new File("./");

        String name1 = "file1";
        String name2 = "file2";
        String name3 = "file3";
        Exception exception = new IOException();

//        System.out.println(file1.toString());
        try {
            ValidationUtility.checkIsDirectory(file1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkIsDirectory(file2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkIsDirectory(file3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotEmpty1() {
        String name1 = "collection1";
        String name2 = "collection2";
        String name3 = "collection3";

        Collection<String> collection1 = new ArrayList<String>();
        Collection<String> collection2 = null;
        Collection<String> collection3 = new ArrayList<String>();

        collection1.add("ok");
        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotEmpty(collection1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmpty(collection2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmpty(collection3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotNullNorEmpty1() {
        String name1 = "collection1";
        String name2 = "collection2";
        String name3 = "collection3";

        Collection<String> collection1 = new ArrayList<String>();
        Collection<String> collection2 = null;
        Collection<String> collection3 = new ArrayList<String>();

        collection1.add("ok");
        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotNullNorEmpty(collection1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNullNorEmpty(collection2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNullNorEmpty(collection3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotEmpty2() {
        String name1 = "map1";
        String name2 = "map2";
        String name3 = "map3";

        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = null;
        Map<String, Integer> map3 = new HashMap<String, Integer>();


        map1.put("ok", 1);
        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotEmpty(map1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmpty(map2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmpty(map3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotNullNorEmpty2() {
        String name1 = "map1";
        String name2 = "map2";
        String name3 = "map3";

        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = null;
        Map<String, Integer> map3 = new HashMap<String, Integer>();


        map1.put("ok", 1);
        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotNullNorEmpty(map1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNullNorEmpty(map2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNullNorEmpty(map3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotNullElements() {
        String name1 = "collection1";
        String name2 = "collection2";
        String name3 = "collection3";

        Collection<String> collection1 = new ArrayList<String>();
        Collection<String> collection2 = null;
        Collection<String> collection3 = new ArrayList<String>();

        collection1.add("ok");
        collection1.add(null);

        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotNullElements(collection1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNullElements(collection2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNullElements(collection3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotEmptyElements() {
        String name1 = "collection1";
        String name2 = "collection2";
        String name3 = "collection3";
        String name4 = "collection4";
        String name5 = "collection5";

        Collection<String> collection1 = new ArrayList<String>();
        Collection<String> collection2 = null;
        Collection<ArrayList<String>> collection3 = new ArrayList<ArrayList<String>>();
        Collection<HashMap<String, Integer>> collection4 = new ArrayList<HashMap<String, Integer>>();
        Collection<String> collection5 = new ArrayList<String>();

        collection1.add("ok ");
        collection1.add("  ");
        collection1.add(null);


        ((ArrayList<ArrayList<String>>) collection3).add(new ArrayList<String>());
        ((ArrayList<HashMap<String, Integer>>) collection4).add(new HashMap<String, Integer>());
        boolean trimStrings = true;
        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotEmptyElements(collection1, trimStrings, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmptyElements(collection2, trimStrings, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmptyElements(collection3, trimStrings, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }

        try {
            ValidationUtility.checkNotEmptyElements(collection4, trimStrings, name4, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmptyElements(collection5, trimStrings, name5, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }

    }

    @Test
    public void checkNotNullKeys() {
        String name1 = "map1";
        String name2 = "map2";
        String name3 = "map3";

        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = null;
        Map<String, Integer> map3 = new HashMap<String, Integer>();


        map1.put("ok", 1);
        map3.put(null, 2);
        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotNullKeys(map1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNullKeys(map2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNullKeys(map3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotNullValues() {
        String name1 = "map1";
        String name2 = "map2";
        String name3 = "map3";

        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = null;
        Map<String, Integer> map3 = new HashMap<String, Integer>();


        map1.put("ok", null);
        map3.put(null, 2);
        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotNullValues(map1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNullValues(map2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNullValues(map3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotEmptyKeys() {
        String name1 = "map1";
        String name2 = "map2";
        String name3 = "map3";
        String name4 = "map4";
        String name5 = "map5";

        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = null;
        Map<String, Integer> map3 = new HashMap<String, Integer>();
        Map<ArrayList<String>, Integer> map4 = new HashMap<ArrayList<String>, Integer>();
        Map<HashMap<String, Integer>, Integer> map5 = new HashMap<HashMap<String, Integer>, Integer>();
        map1.put("ok ", 1);
        map3.put(" ", 3);
        map4.put(new ArrayList<String>(), 1);
        map5.put(new HashMap<String, Integer>(), 5);

        boolean trimStrings = true;
        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotEmptyKeys(map1, trimStrings, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmptyKeys(map2, trimStrings, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmptyKeys(map3, trimStrings, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmptyKeys(map4, trimStrings, name4, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmptyKeys(map5, trimStrings, name5, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotEmptyValues() {
        String name1 = "map1";
        String name2 = "map2";
        String name3 = "map3";
        String name4 = "map4";
        String name5 = "map5";

        Map<Integer, String> map1 = new HashMap<Integer, String>();
        Map<String, Integer> map2 = null;
        Map<Integer, String> map3 = new HashMap<Integer, String>();
        Map<Integer, ArrayList<String>> map4 = new HashMap<Integer, ArrayList<String>>();
        Map<Integer, HashMap<String, Integer>> map5 = new HashMap<Integer, HashMap<String, Integer>>();
        map1.put(1, "ok");
        map3.put(3, " ");
        map4.put(1, new ArrayList<String>());
        map5.put(3, new HashMap<String, Integer>());

        boolean trimStrings = true;
        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotEmptyValues(map1, trimStrings, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmptyValues(map2, trimStrings, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmptyValues(map3, trimStrings, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmptyValues(map4, trimStrings, name4, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotEmptyValues(map5, trimStrings, name5, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNegative() {
        double value1 = 0;
        double value2 = 1;
        double value3 = -1;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";
        Exception exception = new IOException();

        try {
            ValidationUtility.checkNegative(value1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNegative(value2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNegative(value3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkPositive() {
        double value1 = 0;
        double value2 = 1;
        double value3 = -1;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";
        Exception exception = new IOException();

        try {
            ValidationUtility.checkPositive(value1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkPositive(value2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkPositive(value3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotNegative() {
        double value1 = 0;
        double value2 = 1;
        double value3 = -1;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";
        Exception exception = new IOException();

        try {
            ValidationUtility.checkNotNegative(value1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNegative(value2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNegative(value3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotPositive() {
        double value1 = 0;
        double value2 = 1;
        double value3 = -1;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";
        Exception exception = new IOException();

        try {
            ValidationUtility.checkNotPositive(value1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotPositive(value2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotPositive(value3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotZero() {
        double value1 = 0;
        double value2 = 1;
        double value3 = -1;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";
        Exception exception = new IOException();

        try {
            ValidationUtility.checkNotZero(value1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotZero(value2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotZero(value3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkGreaterThan() {
        double value1 = 0;
        double value2 = 1;
        double value3 = -1;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";
        Exception exception = new IOException();
        boolean inclusive = true;
        double number = 0.0;

        try {
            ValidationUtility.checkGreaterThan(value1, number, inclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkGreaterThan(value2, number, inclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkGreaterThan(value3, number, inclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }

        try {
            ValidationUtility.checkGreaterThan(value1, number, !inclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkGreaterThan(value2, number, !inclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkGreaterThan(value3, number, !inclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }

    }

    @Test
    public void checkLessThan() {
        double value1 = 0;
        double value2 = 1;
        double value3 = -1;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";
        Exception exception = new IOException();
        boolean inclusive = true;
        double number = 0.0;

        try {
            ValidationUtility.checkLessThan(value1, number, inclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkLessThan(value2, number, inclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkLessThan(value3, number, inclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }

        try {
            ValidationUtility.checkLessThan(value1, number, !inclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkLessThan(value2, number, !inclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkLessThan(value3, number, !inclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }

    }

    @Test
    public void checkInRange() {
        double value1 = 0;
        double value2 = 1;
        double value3 = 0.5;
        double value4 = -1;
        double value5 =2;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";
        String name4 = "value4";
        String name5 = "value5";
        Exception exception = new IOException();
        boolean fromInclusive = true;
        boolean toInclusive = true;
        double from = 0.0;
        double to = 1.0;

        try {
            ValidationUtility.checkInRange(value1, from, to, fromInclusive, toInclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value2, from, to, fromInclusive, toInclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value3, from, to, fromInclusive, toInclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value4, from, to, fromInclusive, toInclusive, name4, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        ///////////////////////
        try {
            ValidationUtility.checkInRange(value1, from, to, !fromInclusive, toInclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value2, from, to, !fromInclusive, toInclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value3, from, to, !fromInclusive, toInclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value4, from, to, !fromInclusive, toInclusive, name4, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }        try {
            ValidationUtility.checkInRange(value5, from, to, !fromInclusive, toInclusive, name5, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
////////////////////////////////
        try {
            ValidationUtility.checkInRange(value1, from, to, fromInclusive, !toInclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value2, from, to, fromInclusive, !toInclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value3, from, to, fromInclusive, !toInclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value4, from, to, fromInclusive, !toInclusive, name4, exception.getClass());

        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        //////////////////////////////////
        try {
            ValidationUtility.checkInRange(value1, from, to, !fromInclusive, !toInclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value2, from, to, !fromInclusive, !toInclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value3, from, to, !fromInclusive, !toInclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value4, from, to, !fromInclusive, !toInclusive, name4, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNegative1() {
        long value1 = 0;
        long value2 = 1;
        long value3 = -1;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";

        Exception exception = new IOException();
        try {
            ValidationUtility.checkNegative(value1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNegative(value2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNegative(value3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkPositive1() {
        long value1 = 0;
        long value2 = 1;
        long value3 = -1;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";

        Exception exception = new IOException();
        try {
            ValidationUtility.checkPositive(value1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkPositive(value2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkPositive(value3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotNegative1() {
        long value1 = 0;
        long value2 = 1;
        long value3 = -1;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";

        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotNegative(value1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNegative(value2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotNegative(value3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotPositive1() {
        long value1 = 0;
        long value2 = 1;
        long value3 = -1;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";

        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotPositive(value1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotPositive(value2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotPositive(value3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    }

    @Test
    public void checkNotZero1() {
        long value1 = 0;
        long value2 = 1;
        long value3 = -1;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";

        Exception exception = new IOException();
        try {
            ValidationUtility.checkNotZero(value1, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotZero(value2, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkNotZero(value3, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }


    }

    @Test
    public void checkGreaterThan1() {
        boolean inclusive = true;
        long value1 = 0;
        long value2 = 1;
        long value3 = -1;
        long number =0;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";

        Exception exception = new IOException();
        try {
            ValidationUtility.checkGreaterThan(value1,number,inclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }        try {
            ValidationUtility.checkGreaterThan(value2,number,inclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }        try {
            ValidationUtility.checkGreaterThan(value3,number,inclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
///////////////////////
        try {
            ValidationUtility.checkGreaterThan(value1,number,!inclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }        try {
            ValidationUtility.checkGreaterThan(value2,number,!inclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }        try {
            ValidationUtility.checkGreaterThan(value3,number,!inclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }

    }


    @Test
    public void checkLessThan1() {
        boolean inclusive = true;
        long value1 = 0;
        long value2 = 1;
        long value3 = -1;
        long number =0;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";

        Exception exception = new IOException();
        try {
            ValidationUtility.checkLessThan(value1,number,inclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }        try {
            ValidationUtility.checkLessThan(value2,number,inclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }        try {
            ValidationUtility.checkLessThan(value3,number,inclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        ////////////////
        try {
            ValidationUtility.checkLessThan(value1,number,!inclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }        try {
            ValidationUtility.checkLessThan(value2,number,!inclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }        try {
            ValidationUtility.checkLessThan(value3,number,!inclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }

    }

    @Test
    public void checkInRange1() {
        boolean inclusive = true;
        long value1 = 1;
        long value2 = 2;
        long value3 = 3;
        long value4 = 4;
        long value5 = 5;
        String name1 = "value1";
        String name2 = "value2";
        String name3 = "value3";
        String name4 = "value4";
        String name5 = "value5";
        long from = 2;
        long to=4;
        boolean fromInclusive=true;
        boolean toInclusive = true;


        Exception exception = new IOException();

        try {
            ValidationUtility.checkInRange(value1,from,to,fromInclusive,toInclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
                try {
            ValidationUtility.checkInRange(value2,from,to,fromInclusive,toInclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
                try {
            ValidationUtility.checkInRange(value3,from,to,fromInclusive,toInclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
                try {
            ValidationUtility.checkInRange(value4,from,to,fromInclusive,toInclusive, name4, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
                try {
            ValidationUtility.checkInRange(value5,from,to,fromInclusive,toInclusive, name5, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
    //////////////////////////////////////////////

        try {
            ValidationUtility.checkInRange(value1,from,to,!fromInclusive,toInclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value2,from,to,!fromInclusive,toInclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value3,from,to,!fromInclusive,toInclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value4,from,to,!fromInclusive,toInclusive, name4, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value5,from,to,!fromInclusive,toInclusive, name5, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        ///////////////////////
        try {
            ValidationUtility.checkInRange(value1,from,to,fromInclusive,toInclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value2,from,to,fromInclusive,!toInclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value3,from,to,fromInclusive,!toInclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value4,from,to,fromInclusive,!toInclusive, name4, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value5,from,to,fromInclusive,!toInclusive, name5, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        ///////////////////////////////////
        try {
            ValidationUtility.checkInRange(value1,from,to,!fromInclusive,toInclusive, name1, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value2,from,to,!fromInclusive,!toInclusive, name2, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value3,from,to,!fromInclusive,!toInclusive, name3, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value4,from,to,!fromInclusive,!toInclusive, name4, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        try {
            ValidationUtility.checkInRange(value5,from,to,!fromInclusive,!toInclusive, name5, exception.getClass());
        } catch (Throwable throwable) {
            System.out.println(throwable.toString());
        }
        }

    }