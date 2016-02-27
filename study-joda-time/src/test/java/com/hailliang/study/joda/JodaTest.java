package com.hailliang.study.joda;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.Interval;
import org.joda.time.Partial;
import org.joda.time.Period;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;

public class JodaTest {

	@Test
	public void testInstant01() {
		DateTime dateTime01 = new DateTime(new Instant());
		DateTime dateTime02 = new Instant().toDateTime();
		/****
		 * 输出结果：
		 * 		2016-02-27T07:20:36.643Z
		 * 		2016-02-27T15:20:36.681+08:00
		 */
		System.out.println(dateTime01);
		System.out.println(dateTime02);
	}
	
	
	@Test 
	public void testInterval02() {
		Interval interval = new Interval(1000, 5000);
		System.out.println(interval); //result: 1970-01-01T08:00:01.000+08:00/1970-01-01T08:00:05.000+08:00
		System.out.println(interval.getStartMillis());
		System.out.println(interval.getEndMillis());
		System.out.println(interval.getStart().toString("yyyy-MM-dd hh:mm:ss")); //result: 1970-01-01 08:00:01
		System.out.println(interval.getEnd().toString("yyyy-MM-dd hh:mm:ss"));   //result: 1970-01-01 08:00:05
	}
	
	
	@Test
	public void testDuration03() {
		Duration duration = new Duration(1000, 5000);
		System.out.println(duration.getStandardDays());    //result: 0
		System.out.println(duration.getStandardHours());   //result: 0
		System.out.println(duration.getStandardMinutes()); //result: 0
		System.out.println(duration.getStandardSeconds()); //result: 4
		System.out.println(duration.getMillis());		   //result: 4000
	}
	
	@Test
	public void testPeriod04() {
		Period period = new Period(1234L, 5000000000L);
		System.out.println(period.getYears());
		System.out.println(period.getMonths());
		System.out.println(period.getDays());
		System.out.println(period.getHours());
		System.out.println(period.getMinutes());
		System.out.println(period.getSeconds());
		System.out.println(period.getMillis());
		System.out.println(period.getWeeks());
	}
	
	
	@Test
	public void testChronology05() {
		Chronology chronology = ISOChronology.getInstance();
		System.out.println(chronology.getZone());
		
		Chronology newChronology = chronology.withZone(DateTimeZone.forID("Europe/London"));
		System.out.println(newChronology.getZone());
	}
	
	
	@Test
	public void testPartial06() {
		Chronology chronology = ISOChronology.getInstance(DateTimeZone.forID("Asia/Shanghai"));
		Partial partial = new Partial(chronology).with(DateTimeFieldType.dayOfWeek(), 5)
			     									.with(DateTimeFieldType.hourOfDay(), 12)
			     									.with(DateTimeFieldType.minuteOfHour(), 20);;
		System.out.println(partial.toString("yyyy-MM-dd hh:mm:ss"));
		System.out.println(partial.getFieldTypes().length);
		for (DateTimeFieldType dtft : partial.getFieldTypes()) {
			System.out.println(dtft);
		}
	}
	
}
