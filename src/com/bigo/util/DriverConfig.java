package com.bigo.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverConfig {
	public static Properties pros = new Properties();
	// 获取设备数据：静态代码块，类加载的时候执行
	static{
		InputStream inputStream = ClassLoader.getSystemResourceAsStream("drivers.properties");
		try {
			pros.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public AppiumDriver newDriver() throws Exception{
		return newDriver("");
	}
	

	public AppiumDriver newDriver(String deviceN) throws Exception{

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", pros.getProperty("deviceName" + deviceN));   // 使用的手机类型或模拟器类型，真机时输入Android
		capabilities.setCapability("udid", pros.getProperty("udid" + deviceN));
		capabilities.setCapability("platformVersion", pros.getProperty("platformVersion" + deviceN));// 手机操作系统版本，可不更改
		URL url = new URL("http://" + pros.getProperty("ip" + deviceN) + ":" + pros.getProperty("port" + deviceN) + "/wd/hub");
		if("IOS".equals(deviceN)){
			capabilities.setCapability("platformName", pros.getProperty("platformName" + deviceN));// 你要测试的手机操作系统
			capabilities.setCapability("autoacceptAlerts", true);  //
			capabilities.setCapability("bundleId", pros.getProperty("bundleId" + deviceN));
			return new IOSDriver<WebElement>(url, capabilities);// 若测试多台手机需为开启多个appium，且修改4725（一台对应一个）		
		}else{
			capabilities.setCapability("platformName", pros.getProperty("platformName"));// 你要测试的手机操作系统
			capabilities.setCapability("appPackage", pros.getProperty("appPackage"));// 你想运行的Android应用的包名
			capabilities.setCapability("appActivity",pros.getProperty("appActivity"));// 你要启动的Android
			capabilities.setCapability("unicodeKeyboard", true);  //
			capabilities.setCapability("resetKeyboard", true);  //恢复输入法
			return new AndroidDriver<WebElement>(url, capabilities);// 若测试多台手机需为开启多个appium，且修改4725（一台对应一个）
		}	
	}

}
