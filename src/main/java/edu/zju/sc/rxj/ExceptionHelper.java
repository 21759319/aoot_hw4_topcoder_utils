package edu.zju.sc.rxj;
/**
 * <p>This is a static helper class that provides methods for constructing exception instances
 * using reflection. It is used by ValidationUtility, PropertiesUtility and JDBCUtility. Thread
 * Safety: This class is immutable and thread safe when array parameters passed to it are used by
 * the caller in thread safe manner.</>
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class ExceptionHelper {

  /**
   * <p>This is a static helper class that provides methods for constructing exception instances
   * using
   * reflection. It is used by ValidationUtility, PropertiesUtility and JDBCUtility. Thread Safety:
   * This class is immutable and thread safe when array parameters passed to it are used by the
   * caller in thread safe manner.</p>
   */
  private ExceptionHelper() {

  }

  /**
   * Constructs an exception of the specified type with the given message. Generic Parameters: T -
   * the type of the exception to be created Parameters: exceptionClass - the exception class
   * message - the message Returns: the constructed exception instance (not null) Throws: Exception
   * if any error occurred when using the reflection Note: exceptions are populated without wrapping
   * in this method.
   *
   * @param exceptionClass the exception class
   * @param message the message
   * @return the constructed exception instance (not null)
   * @throws Exception if any error occurred when using the reflection
   */
  public static <T extends Throwable> T constructException(final Class<T> exceptionClass,
      final String message) throws Exception {

    Constructor<T> constructor = null;

    constructor = exceptionClass.getConstructor(String.class);

    T result = null;

    result = constructor.newInstance(message);

    return result;
  }

  /**
   * Constructs an exception of the specified type with the given message and cause. Generic
   * Parameters: T - the type of the exception to be created Parameters: exceptionClass - the
   * exception class message - the message cause - the exception cause Returns: the constructed
   * exception instance (not null) Throws: Exception if any error occurred when using the reflection
   * Note: exceptions are populated without wrapping in this method.
   *
   * @param cause the exception cause
   * @param exceptionClass the exception class
   * @param message the message
   * @return the constructed exception instance (not null)
   * @throws Exception if any error occurred when using the reflection
   */
  public static <T extends Throwable> T constructException(final Class<T> exceptionClass,
      final String message, final Throwable cause) throws Exception {

    Constructor<T> constructor = null;
    constructor = exceptionClass.getConstructor(String.class, Throwable.class);
    T result = null;

    result = constructor.newInstance(message, cause);

    return result;

  }
}

