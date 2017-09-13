package com.bigo.test;

import io.appium.java_client.android.AndroidDriver;

public class Screen {
	public static void switchRightLineTimes(AndroidDriver driver,int times) {
		try {
			int width = driver.manage().window().getSize().width;
			int height = driver.manage().window().getSize().height;
			for(int i=0;i<times;i++){
				driver.swipe(width/5,height/2,width*4/5,height/2,500);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
