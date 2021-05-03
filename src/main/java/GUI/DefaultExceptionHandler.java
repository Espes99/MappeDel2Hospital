package GUI;

import org.apache.log4j.Logger;

/**
 * This class is for logging errors outside try and catch
 */
public class DefaultExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final Logger LOGGER = Logger.getLogger(DefaultExceptionHandler.class.getName());
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LOGGER.fatal(
                "This exception was caught by the default exception handler and has not been handled anywhere else."
        );
        LOGGER.fatal(e.getMessage(), e);
    }

}