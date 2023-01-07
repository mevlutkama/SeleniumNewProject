package tests.day15;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day15_Log4J2 {

    // Create object
    private static Logger logger = LogManager.getLogger(Day15_Log4J2.class.getName());

    @Test
    public void log4jTest(){

        // Use logger object to log/print information
        logger.fatal("Fatal Log !!!!");// Prints by default
        logger.error("Error Log !!!!");// Prints by default
        logger.warn("Warning Log !!!!");
        logger.debug("Warning Log !!!!");
        logger.info("Info Log !!!!");
    }
}
