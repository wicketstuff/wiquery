package org.wicketstuff.wiquery.ui.datepicker;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wicketstuff.wiquery.tester.WiQueryTestCase;

import static org.junit.Assert.*;

public class DatePickerNumberOfMonthsTestCase extends WiQueryTestCase
{
	protected static final Logger log = LoggerFactory
		.getLogger(DatePickerNumberOfMonthsTestCase.class);

	@Test
	public void testGetJavaScriptOption()
	{
		DatePickerDuration duration = new DatePickerDuration(Short.parseShort("5"));

		// Short param
		String expectedJavascript = "5";
		String generatedJavascript = duration.getJavascriptOption().toString();

		log.info(expectedJavascript);
		log.info(generatedJavascript);
		assertEquals(generatedJavascript, expectedJavascript);

		// DurationEnum param
		duration.setDurationEnumParam(DatePickerDuration.DurationEnum.FAST);
		expectedJavascript = DatePickerDuration.DurationEnum.FAST.toString();
		generatedJavascript = duration.getJavascriptOption().toString();

		log.info(expectedJavascript);
		log.info(generatedJavascript);
		assertEquals(generatedJavascript, expectedJavascript);

		// Null param
		duration.setDurationEnumParam(null);
		try
		{
			generatedJavascript = duration.getJavascriptOption().toString();
			fail();
		}
		catch (Exception e)
		{
			// We have an expected error
			assertEquals("The DatePickerDuration must have one not null parameter", e.getMessage());
		}
	}

	@Override
	protected Logger getLog()
	{
		return log;
	}
}
