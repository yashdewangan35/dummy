package automation;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Calendor_AVd 
{
	public static void main(String[] args) throws Exception 
	{
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \" appium -a 0.0.0.0 -p 4723 \"");
		//get address of appium server
		
		URL u= new URL("http", "0.0.0.0", 4723, "/wd/hub");
		

		
		//provide device and app details
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion", "4.2.2");
		dc.setCapability("appPackage","com.android.calendar");
		dc.setCapability("appActivity","com.android.calendar.AllInOneActivity");
		
		//create driver object to launch app in device
		AndroidDriver driver;
		while(2>1)  //infinite group
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception ex)
			{
				
			}
		}
		try
		{
			
		driver.context("NATIVE_APP");    //Native App measns - no req of net connection
		int w=driver.manage().window().getSize().getWidth();
		System.out.println(w);
		int h=driver.manage().window().getSize().getHeight();
		System.out.println(h);
		TouchAction ta=new TouchAction(driver);
		
		//swipe from left to right
		int a=(int)(w*0.7);  //right
		int b=(int)(h/2);
		int temp=(int)(w*0.9); //left
		ta.press(a,b).moveTo(temp-a,0).release().perform();
		Thread.sleep(5000);
		
		int v=driver.manage().window().getSize().getWidth();
		System.out.println(v);
		int h1=driver.manage().window().getSize().getHeight();
		System.out.println(h1);
		
		Thread.sleep(5000);
		
		//swipe from right to left
		int c=(int)(v*0.9);   //right
		int d=(int)(h1/2);
		int temp1=(int)(v*0.7); // left

		ta.press(c,d).moveTo(temp1-c,0).release().perform();
		Thread.sleep(5000);
		
		
		//close app
		driver.closeApp();
	   }
	    catch (Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
        
	    //stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskKill /F /IM cmd.exe");
    }
}
