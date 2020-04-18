package com.bobo.one.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class TestSchedule {

	/***
	 * SCheduled run every 1 minute
	 */
	//@Scheduled(fixedRate=60000)
	public void test1(){
		System.out.println("Executing test1..............");
		System.out.println("Test 1 is scheduled run every 1 minutes");
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End test1.");
	}
	/***
	 * SCheduled run every 1 seconds
	 */
	//@Scheduled(fixedRate=30000)
	public void test2(){
		System.out.println("Executing test2..............");
		System.out.println("Test 2 is scheduled run every 30 seconds");
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End test 2.");
	}
}
