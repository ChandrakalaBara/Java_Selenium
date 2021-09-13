package com.techigai.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.techigai.commonLib.WebPage;

public class log4jDemo {
	private static Logger logger = LogManager.getLogger(WebPage.class);
	
	public static void main(String[] args) {
		
		logger.trace("This is a trace message");
		logger.debug("This is a debug message");
		logger.info("This is a info message");
		logger.warn("This is a warn message");
		logger.error("This is a error message");
		logger.fatal("This is a fatal message");
		
	}
}
