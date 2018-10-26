package edu.zju.sc.rxj;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;


/**
 * This is a static helper class that provides log message generation functionality for
 * LoggingWrapperUtility and Log4jUtility.
 *
 * <p>
 * Thread Safety: This class is immutable and thread safe when array parameters passed to it are
 * used by the caller in thread safe manner.</P>
 */
class LoggingUtilityHelper {

  /**
   * Empty private constructor.
   *
   * <p>
   * Implementation Notes: Do nothing.</P>
   */
  private LoggingUtilityHelper() {
  }

  /**
   * Retrieves the method entrance log message.
   *
   * <p>
   * Parameters: signature - the signature that uniquely identifies the method (e.g.
   * className#methodName)</P>
   *
   * <p>
   * Returns: the constructed method entrance message</P>
   *
   * @param signature the signature that uniquely identifies the method (e.g. className#methodName)
   * @return the constructed method entrance message
   */
  static String getMethodEntranceMessage(String signature) {
    return "Entering method [" + signature + "].";
  }

  /**
   * Retrieves the log message for the given input parameters. It's assumed that paramNames and
   * paramValues contain the same number of elements.
   *
   * <p>
   * Parameters: paramNames - the names of input parameters (not null) paramValues - the values of
   * input parameters (not null)</P>
   *
   * <p>
   * Returns: the constructed log message</P>
   *
   * <p>
   * Implementation Notes: 1. sb = new StringBuilder("Input parameters ["); 2. For i = 0 ..
   * paramNames.length - 1 do: 2.1. If i != 0 then 2.1.1. sb.append(" ,"); 2.2.
   * sb.append(paramNames[i]).append(":").append(paramValues[i]); 3. sb.append("]"); 4. Return
   * sb.toString().</P>
   *
   * @param paramValues the values of input parameters (not null)
   * @param paramNames the names of input parameters (not null)
   * @return the constructed log message
   */
  static String getInputParametersMessage(String[] paramNames, Object[] paramValues) {
    StringBuilder sb = new StringBuilder("Input parameters [");
    for (int i = 0; i < paramNames.length; i++) {
      if (i != 0) {
        sb.append(" ,");
      }
      sb.append(paramNames[i]).append(":").append(paramValues[i]);
    }

    sb.append("]");
    return sb.toString();
  }

  /**
   * Retrieves the method exit log message.
   *
   * <p>
   * Parameters: signature - the signature that uniquely identifies the method (e.g.
   * className#methodName) entranceTimestamp - the method entrance timestamp (null if not
   * available), is used for calculating method execution time</P>
   *
   * <p>
   * Returns: the constructed method exit message</P>
   *
   * <p>
   * Implementation Notes: 1. sb = new StringBuilder("Exiting method ["); 2.
   * sb.append(signature).append("]"); 3. If entranceTimestamp != null then 3.1. sb.append(", time
   * spent in the method: ").append(new Date().getTime() - entranceTimestamp.getTime()).append("
   * milliseconds"); 4. sb.append('.'); 5. Return sb.toString().</P>
   *
   * @param entranceTimestamp the method entrance timestamp (null if not available), is used for
   *        calculating method execution time
   * @param signature the signature that uniquely identifies the method (e.g. className#methodName)
   * @return the constructed method exit message
   */
  static String getMethodExitMessage(String signature, Date entranceTimestamp) {
    StringBuilder sb = new StringBuilder("Exiting method [");
    sb.append(signature).append("]");
    if (entranceTimestamp != null) {
      sb.append(", time spent in the method: ")
          .append(new Date().getTime() - entranceTimestamp.getTime()).append(" milliseconds");
    }
    sb.append('.');
    return sb.toString();
  }

  /**
   * Retrieves the log message for the given method output value.
   *
   * <p>
   * Parameters: value - the value returned by the method</P>
   *
   * <p>
   * Returns: the constructed log message</P>
   * @param value the value returned by the method
   * @return the constructed log message
   */
  static String getOutputValueMessage(Object value) {
    return "Output parameter: " + value.toString();
  }

  /**
   * Retrieves the exception log message.
   *
   * <p>
   * Parameters: signature - the signature that uniquely identifies the method (e.g.
   * className#methodName) exception - the exception to be logged (assumed to be not null)</P>
   *
   * <p>
   * Returns: the retrieved exception message</P>
   * @param exception the exception to be logged (assumed to be not null)
   * @param signature the signature that uniquely identifies the method (e.g. className#methodName)
   * @return the retrieved exception message
   */
  static String getExceptionMessage(String signature, Throwable exception) {
    StringBuilder sb = new StringBuilder("Error in method [");
    sb.append(signature).append("], details: ").append(exception.getMessage());
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(out);
    ps.println();
    exception.printStackTrace(ps);
    String stackTrace = out.toString();
    sb.append(stackTrace);
    return sb.toString();
  }
}

