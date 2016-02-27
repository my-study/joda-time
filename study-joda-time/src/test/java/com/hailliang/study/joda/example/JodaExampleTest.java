package com.hailliang.study.joda.example;

import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.MonthDay;
import org.joda.time.Period;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;

public class JodaExampleTest {

	/**
	 * 获取当前日期和年月日
	 */
	@Test
	public void test01() {
		LocalDate now = new LocalDate();
		//DateTime now = new DateTime();
		
		System.out.println(now.toString());
		int year = now.getYear();
		int month = now.getMonthOfYear();
		int day = now.getDayOfMonth();
		// now.getDayOfWeek();
		
		System.out.println(year + "-" + month + "-" + day);
	}
	
	/**
	 * 获取某个特定的日期
	 */
	@Test
	public void test02() {
		LocalDate now1 = new LocalDate(2015, 11, 9);
		DateTime now2 = new DateTime(2015, 11, 9, 7, 15);
		System.out.println(now1);	//result: 2015-11-09
		System.out.println(now2);	//result: 2015-11-09T07:15:00.000+08:00
	}
	
	/**
	 * 判断两个日期的关系
	 */
	@Test
	public void test03() {
		LocalDate now = new LocalDate(2015, 11, 9);
		LocalDate then = new LocalDate(2015, 11, 9);
		System.out.println(now.isEqual(then));		//result: true
		System.out.println(now.isBefore(then));		//result: false
		System.out.println(now.isAfter(then));		//result: false
	}
	
	/**
	 * 修改/添加/减少日期
	 */
	@Test
	public void test04() {
		LocalDate now = new LocalDate();
		LocalDate then = now.plusYears(1);
		System.out.println(then);  //result: 2017-02-27
		
		then = now.minusYears(1);
		System.out.println(then);  //result: 2015-02-27
		
		then = now.withYear(2016);
		System.out.println(then);  //result: 2016-02-27
	}
	
	/**
	 * 检查重复日期，如生日
	 */
	@Test
	public void test05() {
		MonthDay birth = new MonthDay(2, 27);

		LocalDate now = new LocalDate();
		MonthDay today = new MonthDay(now);

		System.out.println(birth.isEqual(today));
	}
	
	/**
	 * 获取1周/月/日后的日期
	 */
	@Test
	public void test06() {
		LocalDate now = new LocalDate();
		LocalDate then = now.plusWeeks(1);
		System.out.println(then);  //result: 2016-03-05
		
		then = now.plusMonths(1);
		System.out.println(then);  //result: 2016-03-27
		
		then = now.plusDays(1);
		System.out.println(then);  //result: 2016-02-28
	}
	
	/**
	 * 两个日期之间包含多少天，多少个月
	 */
	@Test
	public void test07() {
		LocalDate now = new LocalDate(2015, 2, 27, ISOChronology.getInstance(DateTimeZone.forID("Asia/Shanghai")));
		LocalDate then = new LocalDate(2016, 7, 23, ISOChronology.getInstance(DateTimeZone.forID("Asia/Shanghai")));
		Period period = new Period(now, then);
		System.out.println(period.getDays());  //result: 5
		System.out.println(period.getYears()); //result: 1
		System.out.println(period.getMonths());//result: 4
	}
	
	/**
	 * 获得上个月最后一天
	 */
	@Test
	public void test08() {
		LocalDate now = new LocalDate();
		LocalDate lastDayOfPreviousMonth = now.minusMonths(1).dayOfMonth().withMaximumValue();
		System.out.println(lastDayOfPreviousMonth);
		
		for (DateTimeField dtf : lastDayOfPreviousMonth.getFields()) {
			System.out.println(dtf);
		}
	}
	
	/**
	 * 计算 11 月中第一个星期一
	 */
	@Test
	public void test09() {
		DateTime now = new DateTime();
		now = now.monthOfYear().setCopy(11)
		        .dayOfMonth().withMinimumValue()//获得当月1号
		        .plusDays(6)
		        .dayOfWeek().setCopy(1);//获得星期一
		System.out.println(now);
	}
	
	/**
	 * 计算五年后的第二个月的最后一天
	 */
	@Test
	public void test10() {
		DateTime now = new DateTime();
		DateTime then = now.plusYears(5)
		        .monthOfYear()
		        .setCopy(2)
		        .dayOfMonth()
		        .withMaximumValue();
		System.out.println(then);
	}
}
