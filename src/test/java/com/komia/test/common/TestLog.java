package com.komia.test.common;

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.komia.test.base.TestBase;
public class TestLog extends TestBase{
	private static final Logger LOGGER= LoggerFactory.getLogger(TestLog.class);
	@Test
	public void testSlfj() {
		LOGGER.info("aaa");
		LOGGER.error("error");
	}
}
