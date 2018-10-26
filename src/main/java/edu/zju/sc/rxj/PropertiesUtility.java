package edu.zju.sc.rxj;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;


/**
 * This is a utility class that provides static methods for retrieving properties of different types
 * (String, Integer, Long, Double, Date, Class) from Properties instance. This utility throws en
 * exception specified by the caller if required property is missing or cannot be parsed properly.
 * getSubConfiguration() method allows to extract inner configuration from Properties instance (when
 * "childConfigName.childPropertyName" format is used for property keys).
 *
 * <p>
 * Thread Safety: This class is immutable and thread safe when properties parameters passed to it
 * are used by the caller in thread safe manner.</P>
 */
public class PropertiesUtility {

  private PropertiesUtility() {
  }

  /**
   * Retrieves the string property from the given Properties instance.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown if some error occurred</P>
   *
   * <p>
   * Parameters: properties - the properties container key - the key of the property to be retrieved
   * required - true if property is required, false otherwise (if property is required, but missing,
   * an exception is thrown) exceptionClass - the type of the exception to be thrown if some error
   * occurs</P>
   *
   * <p>
   * Returns: the retrieved string property value (null if property is optional and missing)</P>
   *
   * <p>
   * Throws: T if the property is required, but missing</P>
   *
   * @param exceptionClass the type of the exception to be thrown if some error occurs
   * @param properties the properties container
   * @param key the key of the property to be retrieved
   * @param required true if property is required, false otherwise (if property is required, but
   *        missing, an exception is thrown)
   * @return the retrieved string property value (null if property is optional and missing)
   * @throws T if the property is required, but missing
   */
  public static <T extends Throwable> String getStringProperty(Properties properties, String key,
      boolean required, Class<T> exceptionClass) throws Exception, Throwable {
    String value = (String) properties.getProperty(key);
    if (value == null) {
      if (required) {
        throw ExceptionHelper
            .constructException(exceptionClass, getPropertyTitle(key) + " is required");
      }
      return null;
    }
    return value;
  }

  /**
   * Retrieves the delimited(分割之后的) strings property from the given Properties instance.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown if some error occurred</P>
   *
   * <p>
   * Parameters: properties - the properties container key - the key of the property to be retrieved
   * delimiter - the delimiter regular expression pattern required - true if property is required,
   * false otherwise (if property is required, but missing, an exception is thrown) exceptionClass -
   * the type of the exception to be thrown if some error occurs</P>
   *
   * <p>
   * Returns: the retrieved strings values (null if property is optional and missing)</P>
   *
   * <p>
   * Throws: T if the property is required, but missing</P>
   *
   * @param delimiter the delimiter regular expression pattern
   * @param exceptionClass the type of the exception to be thrown if some error occurs
   * @param properties the properties container
   * @param key the key of the property to be retrieved
   * @param required true if property is required, false otherwise (if property is required, but
   *        missing, an exception is thrown)
   * @return the retrieved strings values (null if property is optional and missing)
   * @throws T if the property is required, but missing
   */
  public static <T extends Throwable> String[] getStringsProperty(Properties properties, String key,
      String delimiter, boolean required, Class<T> exceptionClass) throws Exception, Throwable {
    String value = properties.getProperty(key);
    if (value == null) {
      if (required) {
        throw ExceptionHelper
            .constructException(exceptionClass, getPropertyTitle(key) + " is required");
      }
      return null;
    }
    return value.split(delimiter, -1);
  }

  /**
   * Retrieves the integer property from the given Properties instance.
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown if some error occurred</P>
   *
   * <p>
   * Parameters: properties - the properties container key - the key of the property to be retrieved
   * required - true if property is required, false otherwise (if property is required, but missing,
   * an exception is thrown) exceptionClass - the type of the exception to be thrown if some error
   * occurs</P>
   *
   * <p>
   * Returns: the retrieved integer property value (null if property is optional and missing)</P>
   *
   * <p>
   * Throws: T if the property value has invalid format or is required, but missing</P>
   *
   * @param exceptionClass the type of the exception to be thrown if some error occurs
   * @param properties the properties container
   * @param key the key of the property to be retrieved
   * @param required true if property is required, false otherwise (if property is required, but
   *        missing, an exception is thrown)
   * @return the retrieved integer property value (null if property is optional and missing)
   * @throws T if the property value has invalid format or is required, but missing
   */
  public static <T extends Throwable> Integer getIntegerProperty(Properties properties, String key,
      boolean required, Class<T> exceptionClass) throws Exception, Throwable {
    String value = properties.getProperty(key);
    if (value == null) {
      if (required) {
        throw ExceptionHelper
            .constructException(exceptionClass, getPropertyTitle(key) + " is required");
      } else {
        return null;
      }
    }
    Integer result;
    try {
      result = Integer.valueOf(value);

    } catch (NumberFormatException ex) {
      throw ExceptionHelper
          .constructException(exceptionClass, getPropertyTitle(key) + " should be a valid  integer",
              ex);
    }

    return result;
  }

  /**
   * Retrieves the long integer property from the given Properties instance.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown if some error occurred</P>
   *
   * <p>
   * Parameters: properties - the properties container key - the key of the property to be retrieved
   * required - true if property is required, false otherwise (if property is required, but missing,
   * an exception is thrown) exceptionClass - the type of the exception to be thrown if some error
   * occurs</P>
   *
   * <p>
   * Returns: the retrieved long integer property value (null if property is optional and
   * missing)</P>
   *
   * <p>
   * Throws: T if the property value has invalid format or is required, but missing</P>
   *
   * @param exceptionClass the type of the exception to be thrown if some error occurs
   * @param properties the properties container
   * @param key the key of the property to be retrieved
   * @param required true if property is required, false otherwise (if property is required, but
   *        missing, an exception is thrown)
   * @return the retrieved long integer property value (null if property is optional and missing)
   * @throws T if the property value has invalid format or is required, but missing
   */
  public static <T extends Throwable> Long getLongProperty(Properties properties, String key,
      boolean required, Class<T> exceptionClass) throws Exception, Throwable {
    String value = properties.getProperty(key);
    if (value == null) {
      if (required) {
        throw ExceptionHelper
            .constructException(exceptionClass, getPropertyTitle(key) + " is required");
      } else {
        return null;
      }
    }
    Long result;
    try {
      result = Long.valueOf(value);

    } catch (NumberFormatException ex) {
      throw ExceptionHelper.constructException(exceptionClass,
          getPropertyTitle(key) + " should be a valid long integer", ex);
    }

    return result;
  }

  /**
   * Retrieves the double property from the given Properties instance.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown if some error occurred</P>
   *
   * <p>
   * Parameters: properties - the properties container key - the key of the property to be retrieved
   * required - true if property is required, false otherwise (if property is required, but missing,
   * an exception is thrown) exceptionClass - the type of the exception to be thrown if some error
   * occurs</P>
   *
   * <p>
   * Returns: the retrieved double property value (null if property is optional and missing)</P>
   *
   * @param exceptionClass the type of the exception to be thrown if some error occurs
   * @param properties the properties container
   * @param key the key of the property to be retrieved
   * @param required true if property is required, false otherwise (if property is required, but
   *        missing, an exception is thrown)
   * @return the retrieved double property value (null if property is optional and missing)
   * @throws T if the property value has invalid format or is required, but missing
   */
  public static <T extends Throwable> Double getDoubleProperty(Properties properties, String key,
      boolean required, Class<T> exceptionClass) throws Exception, Throwable {
    String value = properties.getProperty(key);
    if (value == null) {
      if (required) {
        throw ExceptionHelper
            .constructException(exceptionClass, getPropertyTitle(key) + " is required");
      } else {
        return null;
      }
    }
    Double result;
    try {
      ParsePosition parsePosition = new ParsePosition(0);
      result = NumberFormat.getInstance(Locale.US).parse(value, parsePosition).doubleValue();
      if (parsePosition.getIndex() != value.length()) {
        throw ExceptionHelper.constructException(exceptionClass,
            getPropertyTitle(key) + " should be a valid double");
      }
    } catch (Exception ex) {
      throw ExceptionHelper
          .constructException(exceptionClass, getPropertyTitle(key) + " should be a valid double",
              ex);

    }
    return result;
  }

  /**
   * Retrieves the date/time property from the given Properties instance.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown if some error occurred</P>
   *
   * <p>
   * Parameters: properties - the properties container key - the key of the property to be retrieved
   * format - the expected date/time format string required - true if property is required, false
   * otherwise (if property is required, but missing, an exception is thrown) exceptionClass - the
   * type of the exception to be thrown if some error occurs</P>
   *
   * <p>
   * Returns: the retrieved date/time property value (null if property is optional and missing)</P>
   *
   * <p>
   * Throws: T if the property value has invalid format or is required, but missing</P>
   *
   * @param format the expected date/time format string
   * @param exceptionClass the type of the exception to be thrown if some error occurs
   * @param properties the properties container
   * @param key the key of the property to be retrieved
   * @param required true if property is required, false otherwise (if property is required, but
   *        missing, an exception is thrown)
   * @return the retrieved date/time property value (null if property is optional and missing)
   * @throws T if the property value has invalid format or is required, but missing
   */
  public static <T extends Throwable> Date getDateProperty(Properties properties, String key,
      String format, boolean required, Class<T> exceptionClass) throws Exception, Throwable {
    String value = properties.getProperty(key);
    if (value == null) {
      if (required) {
        throw ExceptionHelper
            .constructException(exceptionClass, getPropertyTitle(key) + " is required");
      } else {
        return null;
      }
    }
    ParsePosition parsePosition = new ParsePosition(0);
    Date result = new SimpleDateFormat(format, Locale.US).parse(value, parsePosition);
    if (result == null || parsePosition.getIndex() != value.length()) {
      throw ExceptionHelper.constructException(exceptionClass,
          getPropertyTitle(key) + " should be in format [" + format + "]");
    }

    return result;

  }

  /**
   * Retrieves the class property from the given Properties instance. Property value is expected to
   * contain a full class name.
   *
   * <p>
   * Generic Parameters: T - the type of the exception to be thrown if some error occurred</P>
   *
   * <p>
   * Parameters: properties - the properties container key - the key of the property to be retrieved
   * required - true if property is required, false otherwise (if property is required, but missing,
   * an exception is thrown) exceptionClass - the type of the exception to be thrown if some error
   * occurs</P>
   *
   * <p>
   * Returns: the retrieved class property value (null if property is optional and missing)</P>
   *
   * <p>
   * Throws: T if the property value has invalid format or is required, but missing</P>
   *
   * @param exceptionClass the type of the exception to be thrown if some error occurs
   * @param properties the properties container
   * @param key the key of the property to be retrieved
   * @param required true if property is required, false otherwise (if property is required, but
   *        missing, an exception is thrown)
   * @return the retrieved class property value (null if property is optional and missing)
   * @throws T if the property value has invalid format or is required, but missing
   */
  public static <T extends Throwable> Class<?> getClassProperty(Properties properties, String key,
      boolean required, Class<T> exceptionClass) throws Exception, Throwable {
    String value = properties.getProperty(key);
    if (value == null) {
      if (required) {
        throw ExceptionHelper
            .constructException(exceptionClass, getPropertyTitle(key) + " is required");
      } else {
        return null;
      }
    }
    try {
      Class<?> result = Class.forName(value);
      return result;
    } catch (Exception ex) {
      throw ExceptionHelper.constructException(exceptionClass,
          getPropertyTitle(key) + " contains invalid full class name (" + value + ")", ex);

    }

  }

  /**
   * Retrieves the inner configuration from the configuration stored in Properties container.
   *
   * <p>
   * Parameters: properties - the properties with the main configuration configName - the name of
   * the inner configuration</P>
   *
   * <p>
   * Returns: the Properties container with the extracted inner configuration (not null)</P>
   *
   * @param configName the name of the inner configuration
   * @param properties the properties with the main configuration
   * @return the Properties container with the extracted inner configuration (not null)
   */
  public static Properties getSubConfiguration(Properties properties, String configName) {
    String prefix = configName + ".";
    Properties result = new Properties();
    for (String key : properties.stringPropertyNames()
    ) {
      if (key.startsWith(prefix)) {
        String newkey = key.substring(prefix.length());
        result.put(newkey, properties.get(key));
      }
    }
    return result;
  }

  /**
   * Retrieves the property title to be used in exception message.
   *
   * <p>
   * Parameters: key - the property key</P>
   *
   * <p>
   * Returns: the constructed property title</P>
   *
   * @param key the property key
   * @return the constructed property title
   */
  private static String getPropertyTitle(String key) {

    return "The property '" + key + "'";
  }
}

