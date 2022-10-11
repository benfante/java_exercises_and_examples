package com.javacourse.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
	private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

	public static void main(String[] args) {
		logger.error("This is an error");
		logger.warn("This is an warn");
		logger.info("This is an info");
		logger.debug("This is an debug");
		logger.trace("This is an trace");
		int a = 67;
		logger.debug("The value of a is "+a);
		if (logger.isDebugEnabled()) {
			logger.debug("The value of a is "+a);
		}
		logger.debug("The value of a is {}", a);
	}

}
