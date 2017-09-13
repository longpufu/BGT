package com.bigo.test;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.bigo.util.DriverConfig;

import io.appium.java_client.AppiumDriver;



public class Testcase {
	
	public AppiumDriver driver;
	
	@Before
	public void setUp() throws Exception {
		DriverConfig driverConfig = new DriverConfig();
		driver = driverConfig.newDriver("IOS");
	}
	
	@Test
	public void test1() throws Exception {
		/*	Thread.sleep(8000);
		Point p = driver.findElementByAccessibilityId("community_record_pause").getLocation();
		System.out.println(p.getX()+""+p.getY());
		//new TouchAction(driver).tap(179,550).perform();
		new TouchAction(driver).tap(driver.findElementByAccessibilityId("community_record_pause")).perform();
		Thread.sleep(10000);*/
		//System.out.println(driver.findElementsByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell").size());
		
		
		
		
		
		
/*		List<WebElement> wes = driver.findElementsByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell");
		for(int i = 1 ; i<100 ; i++){
			System.out.println(i);
			wes.get(i-1).click();
			Thread.sleep(10000);
			driver.findElementByAccessibilityId("icon home back").click();
			Thread.sleep(2000);
			if(i%4 == 0 && i != 0){
				System.out.println(driver.manage().window().getSize().height);
				driver.swipe(200, 200, 0, -160, 2000);
				Thread.sleep(3000);
			}
			if(i==30){
				wes = driver.findElementsByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell");
			}
		}
		Thread.sleep(5000);*/
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	public static void main(String[] args){
		
	}

}
