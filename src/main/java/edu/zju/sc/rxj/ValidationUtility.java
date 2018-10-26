package edu.zju.sc.rxj;

import static edu.zju.sc.rxj.ExceptionHelper.constructException;
import static java.lang.Math.abs;

import java.io.File;
import java.util.Collection;
import java.util.Map;

/**
 * This is a utility class that provides static methods for checking whether some arbitrary value
 * meets specific criteria (not null, not empty, positive, negative, etc). If criteria is not met,
 * this utility throws an exception of type specified by the caller.
 *
 * <p>
 * Thread Safety: This class is immutable and thread safe when collection parameters passed to it
 * are used by the caller in thread safe manner.</P>
 */
public class ValidationUtility {

  private ValidationUtility() {
  }

  /**
   * Checks whether the given value is not null. And if this condition is not met, the specified
   * exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is null</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is null
   */
  public static <T extends Throwable> void checkNotNull(final Object value, final String name,
      final Class<T> exceptionClass) throws Exception, Throwable {
    if (value == null) {
      throw constructException(exceptionClass, name + " should not be null");
    }
  }

  /**
   * Checks whether the given string value is not empty (without trimming). And if this condition is
   * not met, the specified exception is thrown. Note that if value is null, exception is not
   * thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is empty</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is empty
   */
  public static <T extends Throwable> void checkNotEmpty(final String value, final String name,
      final Class<T> exceptionClass) throws Exception, Throwable {
    if (value != null && value.equals("")) {
      throw constructException(exceptionClass, name + " should not be empty");
    }

  }

  /**
   * Checks whether the given collection is not empty. And if this condition is not met, the
   * specified exception is thrown. Note that if collection is null, exception is not thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: collection - the collection to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given collection is empty</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param collection the collection to be checked
   * @throws T if the given collection is empty
   */
  public static <T extends Throwable> void checkNotEmpty(Collection<?> collection, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (collection != null && collection.isEmpty()) {
      throw constructException(exceptionClass, name + " should not be empty");
    }
  }

  /**
   * Checks whether the given map value is not empty. And if this condition is not met, the
   * specified exception is thrown. Note that if map is null, exception is not thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: map - the map to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given map is empty</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param map the map to be checked
   * @throws T if the given map is empty
   */
  public static <T extends Throwable> void checkNotEmpty(Map<?, ?> map, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (map != null && map.isEmpty()) {
      throw constructException(exceptionClass, name + " should not be empty");
    }
  }

  /**
   * Checks whether the given string value is not empty (after trimming). And if this condition is
   * not met, the specified exception is thrown. Note that if value is null, exception is not
   * thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is empty</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is empty
   */
  public static <T extends Throwable> void checkNotEmptyAfterTrimming(final String value,
      final String name, final Class<T> exceptionClass) throws Exception, Throwable {
    if (value != null && value.trim().equals("")) {
      throw constructException(exceptionClass, name + " should not be empty (trimmed)");
    }

  }

  /**
   * Checks whether the given string value is not null, nor empty (without trimming). And if this
   * condition is not met, the specified exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is null or empty</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is null or empty
   */

  public static <T extends Throwable> void checkNotNullNorEmpty(final String value,
      final String name, final Class<T> exceptionClass) throws Throwable {
    checkNotNull(value, name, exceptionClass);
    checkNotEmpty(value, name, exceptionClass);
  }

  /**
   * Checks whether the given collection is not null, nor empty. And if this condition is not met,
   * the specified exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: collection - the collection to be checked name - the name associated with the
   * value</P>
   *
   * <p>
   * Throws: T if the given collection is null or empty</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param collection the collection to be checked
   * @throws T if the given collection is null or empty
   */
  public static <T extends Throwable> void checkNotNullNorEmpty(Collection<?> collection,
      String name, Class<T> exceptionClass) throws Throwable {
    checkNotNull(collection, name, exceptionClass);
    checkNotEmpty(collection, name, exceptionClass);

  }

  /**
   * Checks whether the given map is not null, nor empty. And if this condition is not met, the
   * specified exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: map - the map to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given map is null or empty</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param map the map to be checked
   * @throws T if the given map is null or empty
   */
  public static <T extends Throwable> void checkNotNullNorEmpty(Map<?, ?> map, String name,
      Class<T> exceptionClass) throws Throwable {
    checkNotNull(map, name, exceptionClass);
    checkNotEmpty(map, name, exceptionClass);
  }

  /**
   * Checks whether the given string value is not null, nor empty (after trimming). And if this
   * condition is not met, the specified exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is null or empty</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is null or empty
   */

  public static <T extends Throwable> void checkNotNullNorEmptyAfterTrimming(final String value,
      final String name, final Class<T> exceptionClass) throws Throwable {
    checkNotNull(value, name, exceptionClass);
    checkNotEmptyAfterTrimming(value, name, exceptionClass);
  }

  /**
   * Checks whether the given value is an instance of the specified type. And if this condition is
   * not met, the specified exception is thrown. Note that if value is null, exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked expectedType - the expected type of the value name
   * - the name associated with the value exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is not an instance of the expected type</P>
   *
   * @param expectedType the expected type of the value
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is not an instance of the expected type
   */
  public static <T extends Throwable> void checkInstance(final Object value,
      final Class<?> expectedType, final String name, final Class<T> exceptionClass)
      throws Throwable {
    checkNotNull(value, name, exceptionClass);
    if (!expectedType.isInstance(value)) {
      throw constructException(exceptionClass,
          name + " should be an instance of " + expectedType.getName());
    }
  }

  /**
   * Checks whether the given value is null or an instance of the specified type. And if this
   * condition is not met, the specified exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked expectedType - the expected type of the value name
   * - the name associated with the value exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is not null and not an instance of the expected type</P>
   *
   * @param expectedType the expected type of the value
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is not null and not an instance of the expected type
   */
  public static <T extends Throwable> void checkNullOrInstance(final Object value,
      final Class<?> expectedType, final String name, final Class<T> exceptionClass)
      throws Exception, Throwable {
    if (value != null && !expectedType.isInstance(value)) {
      throw constructException(exceptionClass,
          name + " should be null or an instance of " + expectedType.getName());
    }

  }

  /**
   * Checks whether the given File instance points to an existing
   * file or directory. And
   * if this condition is not met, the specified exception is thrown. Note that if file is null,
   * exception is not thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: file - the File instance to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given file value represents a not existing file or directory</P>
   *
   * @param file the File instance to be checked
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @throws T if the given file value represents a not existing file or directory
   */
  public static <T extends Throwable> void checkExists(final File file, final String name,
      final Class<T> exceptionClass) throws Exception, Throwable {
    if (file != null && !file.exists()) {
      throw constructException(exceptionClass,
          name + " should point to an existing file or directory");
    }
  }

  /**
   * Checks whether the given File instance points to an existing file. And if this condition is not
   * met, the specified exception is thrown. Note that if file is null, exception is not thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: file - the File instance to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given file value represents a not existing file</P>
   *
   * @param file the File instance to be checked
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @throws T if the given file value represents a not existing file
   */
  public static <T extends Throwable> void checkIsFile(File file, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (file != null && !file.isFile()) {
      throw constructException(exceptionClass, name + " should point to an existing file");
    }
  }

  /**
   * Checks whether the given File instance points to an existing directory. And if this condition
   * is not met, the specified exception is thrown. Note that if file is null, exception is not
   * thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: file - the File instance to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given file value represents a not existing directory</P>
   *
   * @param file the File instance to be checked
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @throws T if the given file value represents a not existing directory
   */
  public static <T extends Throwable> void checkIsDirectory(File file, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (file != null && !file.isDirectory()) {
      throw constructException(exceptionClass, name + " should point to an existing directory");
    }
  }






  /**
   * Checks whether the given collection doesn't contain null elements. And if this condition is not
   * met, the specified exception is thrown. Note that if collection is null, exception is not
   * thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: collection - the collection to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given collection contains null element</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param collection the collection to be checked
   * @throws T if the given collection contains null element
   */
  public static <T extends Throwable> void checkNotNullElements(Collection<?> collection,
      String name, Class<T> exceptionClass) throws Exception, Throwable {
    if (collection == null) {
      return;
    }
    boolean containNull = false;
    for (Object element : collection
    ) {
      if (element == null) {
        containNull = true;
        break;
      }
    }
    if (containNull == true) {
      throw constructException(exceptionClass, name + " should not contain null");
    }
  }

  /**
   * Checks whether the given collection doesn't contain empty elements (strings, collections,
   * maps). And if this condition is not met, the specified exception is thrown. Note that if
   * collection is null, exception is not thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: collection - the collection to be checked trimStrings - true if strings should be
   * trimmed before emptiness check, false otherwise name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given collection contains an empty element (string, collection or map)</P>
   *
   * @param trimStrings true if strings should be trimmed before emptiness check, false otherwise
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param collection the collection to be checked
   * @throws T if the given collection contains an empty element (string, collection or map)
   */
  public static <T extends Throwable> void checkNotEmptyElements(Collection<?> collection,
      boolean trimStrings, String name, Class<T> exceptionClass) throws Exception, Throwable {
    if (collection == null) {
      return;
    }
    boolean containsEmpty = false;
    for (Object element : collection) {
      if (String.class.isInstance(element)) {
        String str = (String) element;
        if (trimStrings) {
          str = str.trim();
        }
        if (str.equals("")) {
          containsEmpty = true;
          break;
        }
      } else if (Collection.class.isInstance(element)) {
        if (((Collection) element).isEmpty()) {
          containsEmpty = true;
          break;
        }

      } else if (Map.class.isInstance(element)) {
        if (((Map) element).isEmpty()) {
          containsEmpty = true;
          break;
        }
      }
    }
    if (containsEmpty) {
      throw constructException(exceptionClass, name + " should not contain empty elements");
    }
  }

  /**
   * Checks whether the given map doesn't contain a null key. And if this condition is not met, the
   * specified exception is thrown. Note that if map is null, exception is not thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: map - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given map contains null key</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param map the value to be checked
   * @throws T if the given map contains null key
   */
  public static <T extends Throwable> void checkNotNullKeys(Map<?, ?> map, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (map != null && map.containsKey(null)) {
      throw constructException(exceptionClass, name + " should not contain null key");
    }

  }

  /**
   * Checks whether the given map doesn't contain a null value. And if this condition is not met,
   * the specified exception is thrown. Note that if map is null, exception is not thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: map - the map to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   * <p>
   * Throws: T if the given map contains null value</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param map the map to be checked
   * @throws T if the given map contains null value
   */
  public static <T extends Throwable> void checkNotNullValues(Map<?, ?> map, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (map != null && map.containsValue(null)) {
      throw constructException(exceptionClass, name + " should not contain null value");
    }
  }

  /**
   * Checks whether the given map doesn't contain empty keys (strings, collection, maps). And if
   * this condition is not met, the specified exception is thrown. Note that if map is null,
   * exception is not thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: map - the map to be checked trimStrings - true if strings should be trimmed before
   * emptiness check, false otherwise name - the name associated with the value exceptionClass - the
   * exception class</P>
   *
   * <p>
   * Throws: T if the given map contains an empty key (string, collection or map)</P>
   *
   * @param trimStrings true if strings should be trimmed before emptiness check, false otherwise
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param map the map to be checked
   * @throws T if the given map contains an empty key (string, collection or map)
   */
  public static <T extends Throwable> void checkNotEmptyKeys(Map<?, ?> map, boolean trimStrings,
      String name, Class<T> exceptionClass) throws Exception, Throwable {
    if (map == null) {
      return;
    }
    boolean containsEmpty = false;
    for (Object key : map.keySet()) {
      if (String.class.isInstance(key)) {
        String str = (String) key;
        if (trimStrings) {
          str = str.trim();
        }
        if (str.equals("")) {
          containsEmpty = true;
          break;
        }
      } else if (Collection.class.isInstance(key)) {
        if (((Collection) key).isEmpty()) {
          containsEmpty = true;
          break;
        }

      } else if (Map.class.isInstance(key)) {
        if (((Map) key).isEmpty()) {
          containsEmpty = true;
          break;
        }
      }
    }
    if (containsEmpty) {
      throw constructException(exceptionClass, name + " should not contain empty keys");
    }
  }


  /**
   * Checks whether the given map doesn't contain empty values (strings, collection, maps). And if
   * this condition is not met, the specified exception is thrown. Note that if map is null,
   * exception is not thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: map - the map to be checked trimStrings - true if strings should be trimmed before
   * emptiness check, false otherwise name - the name associated with the value exceptionClass - the
   * exception class</P>
   *
   * <p>
   * Throws: T if the given map contains an empty value (string, collection or map)</P>
   *
   * @param trimStrings true if strings should be trimmed before emptiness check, false otherwise
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param map the map to be checked
   * @throws T if the given map contains an empty value (string, collection or map)
   */
  public static <T extends Throwable> void checkNotEmptyValues(Map<?, ?> map, boolean trimStrings,
      String name, Class<T> exceptionClass) throws Exception, Throwable {
    if (map == null) {
      return;
    }
    boolean containsEmpty = false;
    for (Object value : map.values()) {
      if (String.class.isInstance(value)) {
        String str = (String) value;
        if (trimStrings) {
          str = str.trim();
        }
        if (str.equals("")) {
          containsEmpty = true;
          break;
        }
      } else if (Collection.class.isInstance(value)) {
        if (((Collection) value).isEmpty()) {
          containsEmpty = true;
          break;
        }

      } else if (Map.class.isInstance(value)) {
        if (((Map) value).isEmpty()) {
          containsEmpty = true;
          break;
        }
      }
    }
    if (containsEmpty) {
      throw constructException(exceptionClass, name + " should not contain empty values");
    }

  }

  /**
   * Checks whether the given value is negative. And if this condition is not met, the specified
   * exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is not negative</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is not negative
   */
  public static <T extends Throwable> void checkNegative(double value, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (value >= 0) {
      throw constructException(exceptionClass, name + " should be negative");
    }
  }

  /**
   * Checks whether the given value is negative. And if this condition is not met, the specified
   * exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is not negative</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is not negative
   */
  public static <T extends Throwable> void checkNegative(long value, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (value >= 0) {
      throw constructException(exceptionClass, name + " should be negative");
    }
  }

  /**
   * Checks whether the given value is positive. And if this condition is not met, the specified
   * exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is not positive</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is not positive
   */
  public static <T extends Throwable> void checkPositive(double value, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (value <= 0) {
      throw constructException(exceptionClass, name + " should be positive");
    }
  }

  /**
   * Checks whether the given value is positive. And if this condition is not met, the specified
   * exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is not positive</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is not positive
   */
  public static <T extends Throwable> void checkPositive(long value, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (value <= 0) {
      throw constructException(exceptionClass, name + " should be positive");
    }
  }

  /**
   * Checks whether the given value is not negative. And if this condition is not met, the specified
   * exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is negative</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is negative
   */

  public static <T extends Throwable> void checkNotNegative(double value, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (value < 0) {
      throw constructException(exceptionClass, name + " should be not negative");
    }
  }


  /**
   * Checks whether the given value is not negative. And if this condition is not met, the specified
   * exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is negative</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is negative
   */
  public static <T extends Throwable> void checkNotNegative(long value, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (value < 0) {
      throw constructException(exceptionClass, name + " should not be negative");
    }
  }

  /**
   * Checks whether the given value is not positive. And if this condition is not met, the specified
   * exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is positive</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is positive
   */
  public static <T extends Throwable> void checkNotPositive(double value, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (value > 0) {
      throw constructException(exceptionClass, name + " should be not positive");
    }
  }

  /**
   * Checks whether the given value is not positive. And if this condition is not met, the specified
   * exception is thrown.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is positive</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is positive
   */
  public static <T extends Throwable> void checkNotPositive(long value, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (value > 0) {
      throw constructException(exceptionClass, name + " should not be positive");
    }
  }
  /**
   * Checks whether the given value is not equal to zero. And if this condition is not met, the
   * specified exception is thrown. Note: Don't forget about "Floating-Point Accuracy/Comparison"
   * problems when checking floating point numbers.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is equal to 0</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is equal to 0
   */

  public static <T extends Throwable> void checkNotZero(double value, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    double err = 1e-6;
    if (abs(value - 0) < err) {
      throw constructException(exceptionClass, name + " should not be equal to 0");
    }
  }




  /**
   * Checks whether the given value is not equal to zero. And if this condition is not met, the
   * specified exception is thrown. Note: Don't forget about "Floating-Point Accuracy/Comparison"
   * problems when checking floating point numbers.
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   * <p>
   * Parameters: value - the value to be checked name - the name associated with the value
   * exceptionClass - the exception class</P>
   * <p>
   * Throws: T if the given value is equal to 0</P>
   *
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is equal to 0
   */
  public static <T extends Throwable> void checkNotZero(long value, String name,
      Class<T> exceptionClass) throws Exception, Throwable {
    if (value == 0) {
      throw constructException(exceptionClass, name + " should not be equal to 0");
    }
  }

  /**
   * Checks whether the given value is greater than (greater than or equal to, if inclusive is true)
   * than the specified number. And if this condition is not met, the specified exception is thrown.
   * Note: Don't forget about "Floating-Point Accuracy/Comparison" problems when checking floating
   * point numbers. Inclusive comparison is recommended to be used with integral types only.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked number - the number the value should be compared to
   * inclusive - true if "greater than or equal to" check should be performed, false if "greater
   * than" check should be performed name - the name associated with the value exceptionClass - the
   * exception class</P>
   *
   * <p>
   * Throws: T if the given value is not greater than (not greater than and not equal to, if
   * inclusive is true) than the specified number</P>
   *
   * @param number the number the value should be compared to
   * @param inclusive true if "greater than or equal to" check should be performed, false if
   *        "greater than" check should be performed
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is not greater than (not greater than and not equal to, if
   *        inclusive is true) than the specified number
   */
  public static <T extends Throwable> void checkGreaterThan(double value, double number,
      boolean inclusive, String name, Class<T> exceptionClass) throws Exception, Throwable {
    double err = 1e-6;
    if (inclusive) {
      if (abs(value - number) < err) {
        return;
      } else if (value < number) {
        throw constructException(exceptionClass,
            name + " should be greater than or equal to " + number);
      }
    } else {
      if (abs(number - value) < err || value < number) {
        throw constructException(exceptionClass, name + " should be greater than " + number);
      }
    }
  }

  /**
   * Checks whether the given value is greater than (greater than or equal to, if inclusive is true)
   * than the specified number. And if this condition is not met, the specified exception is thrown.
   * Note: Don't forget about "Floating-Point Accuracy/Comparison" problems when checking floating
   * point numbers. Inclusive comparison is recommended to be used with integral types only.
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   * <p>
   * Parameters: value - the value to be checked number - the number the value should be compared to
   * inclusive - true if "greater than or equal to" check should be performed, false if "greater
   * than" check should be performed name - the name associated with the value exceptionClass - the
   * exception class</P>
   * <p>
   * Throws: T if the given value is not greater than (not greater than and not equal to, if
   * inclusive is true) than the specified number</P>
   *
   * @param number the number the value should be compared to
   * @param inclusive true if "greater than or equal to" check should be performed, false if
   *        "greater than" check should be performed
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is not greater than (not greater than and not equal to, if
   *        inclusive is true) than the specified number
   */
  public static <T extends Throwable> void checkGreaterThan(long value, long number,
      boolean inclusive, String name, Class<T> exceptionClass) throws Exception, Throwable {
    if (inclusive) {
      if (value < number) {
        throw constructException(exceptionClass,
            name + " should be greater than or equal to " + number);
      }
    } else {
      if (value <= number) {
        throw constructException(exceptionClass, name + " should be greater than" + number);
      }
    }
  }
  /**
   * Checks whether the given value is less than (less than or equal to, if inclusive is true) than
   * the specified number. And if this condition is not met, the specified exception is thrown.
   * Note: Don't forget about "Floating-Point Accuracy/Comparison" problems when checking floating
   * point numbers. Inclusive comparison is recommended to be used with integral types only.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked number - the number the value should be compared to
   * inclusive - true if "less than or equal to" check should be performed, false if "less than"
   * check should be performed name - the name associated with the value exceptionClass - the
   * exception class</P>
   *
   * <p>
   * Throws: T if the given value is not less than (not less than and not equal to, if inclusive is
   * true) than the specified number</P>
   *
   * @param number the number the value should be compared to
   * @param inclusive true if "less than or equal to" check should be performed, false if "less
   *        than" check should be performed
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is not less than (not less than and not equal to, if inclusive is
   *        true) than the specified number
   */

  public static <T extends Throwable> void checkLessThan(double value, double number,
      boolean inclusive, String name, Class<T> exceptionClass) throws Exception, Throwable {
    double err = 1e-6;
    if (inclusive) {
      if (abs(value - number) < err) {
        return;
      } else if (value > number) {
        throw constructException(exceptionClass,
            name + " should be less than or equal to " + number);
      }
    } else {
      if (abs(number - value) < err || value > number) {
        throw constructException(exceptionClass, name + " should be less than " + number);
      }
    }
  }

  /**
   * Checks whether the given value is less than (less than or equal to, if inclusive is true) than
   * the specified number. And if this condition is not met, the specified exception is thrown.
   * Note: Don't forget about "Floating-Point Accuracy/Comparison" problems when checking floating
   * point numbers. Inclusive comparison is recommended to be used with integral types only.
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   * <p>
   * Parameters: value - the value to be checked number - the number the value should be compared to
   * inclusive - true if "less than or equal to" check should be performed, false if "less than"
   * check should be performed name - the name associated with the value exceptionClass - the
   * exception class</P>
   * <p>
   * Throws: T if the given value is not less than (not less than and not equal to, if inclusive is
   * true) than the specified number</P>
   *
   * @param number the number the value should be compared to
   * @param inclusive true if "less than or equal to" check should be performed, false if "less
   *        than" check should be performed
   * @param name the name associated with the value
   * @param exceptionClass the exception class
   * @param value the value to be checked
   * @throws T if the given value is not less than (not less than and not equal to, if inclusive is
   *        true) than the specified number
   */

  public static <T extends Throwable> void checkLessThan(long value, long number, boolean inclusive,
      String name, Class<T> exceptionClass) throws Exception, Throwable {
    if (inclusive) {
      if (value > number) {
        throw constructException(exceptionClass,
            name + " should be less than or equal to " + number);
      }
    } else {
      if (value >= number) {
        throw constructException(exceptionClass, name + " should be less than" + number);
      }
    }
  }

  /**
   * Checks whether the given value is in the specified range. And if this condition is not met, the
   * specified exception is thrown. Note: Don't forget about "Floating-Point Accuracy/Comparison"
   * problems when checking floating point numbers. Inclusive comparison is recommended to be used
   * with integral types only.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   *
   * <p>
   * Parameters: value - the value to be checked from - the start value of the range to - the end
   * value of the range fromInclusive - true if start value is included into the range, false
   * otherwise toInclusive - true if end value is included into the range, false otherwise name -
   * the name associated with the value exceptionClass - the exception class</P>
   *
   * <p>
   * Throws: T if the given value is out of the specified range</P>
   *
   * @param name the name associated with the value
   * @param toInclusive true if end value is included into the range, false otherwise
   * @param from the start value of the range
   * @param exceptionClass the exception class
   * @param to the end value of the range
   * @param fromInclusive true if start value is included into the range, false otherwise
   * @param value the value to be checked
   * @throws T if the given value is out of the specified range
   */
  public static <T extends Throwable> void checkInRange(double value, double from, double to,
      boolean fromInclusive, boolean toInclusive, String name, Class<T> exceptionClass)
      throws Exception, Throwable {
    boolean valid = true;
    double err = 1e-6;
    if (fromInclusive) {
      if (abs(value - from) < err || value > from) {
        valid = true;
      } else {
        valid = false;
      }
    } else {
      if (abs(value - from) < err) {
        valid = false;
      } else {
        valid = (value > from);

      }
    }
    if (valid) {
      if (toInclusive) {
        if (abs(value - to) < err || value < to) {
          valid = true;
        } else {
          valid = false;
        }
      } else {
        if (abs(value - to) < err) {
          valid = false;
        } else {
          valid = (value < to);

        }
      }
    }

    if (!valid) {
      String message =
          name + " should be in the range " + (fromInclusive ? "[" : "(") + from + ", " + to + (
              toInclusive ? "]" : ")");
      throw constructException(exceptionClass, message);
    }

  }



  /**
   * Checks whether the given value is in the specified range. And if this condition is not met, the
   * specified exception is thrown. Note: Don't forget about "Floating-Point Accuracy/Comparison"
   * problems when checking floating point numbers. Inclusive comparison is recommended to be used
   * with integral types only.
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown when validation fails</P>
   * <p>
   * Parameters: value - the value to be checked from - the start value of the range to - the end
   * value of the range fromInclusive - true if start value is included into the range, false
   * otherwise toInclusive - true if end value is included into the range, false otherwise name -
   * the name associated with the value exceptionClass - the exception class</P>
   * <p>
   * Throws: T if the given value is out of the specified range</P>
   *
   * @param name the name associated with the value
   * @param toInclusive true if end value is included into the range, false otherwise
   * @param from the start value of the range
   * @param exceptionClass the exception class
   * @param to the end value of the range
   * @param fromInclusive true if start value is included into the range, false otherwise
   * @param value the value to be checked
   * @throws T if the given value is out of the specified range
   */
  public static <T extends Throwable> void checkInRange(long value,
      long from,
      long to,
      boolean fromInclusive,
      boolean toInclusive,
      String name, Class<T> exceptionClass) throws Exception, Throwable {
    boolean valid;
    if (fromInclusive) {
      valid = (value >= from);

    } else {
      valid = (value > from);
    }
    if (valid) {
      if (toInclusive) {
        valid = (value <= to);
      } else {
        valid = (value < to);
      }
    }
    if (!valid) {
      String message =
          name + " should be in the range " + (fromInclusive ? "[" : "(") + from + ", " + to + (
              toInclusive ? "]" : ")");
      throw constructException(exceptionClass, message);
    }

  }
}

