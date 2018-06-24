package automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Currnt_pkg_currnt_activity 
{
	public static void main(String[] args) throws Exception
	{

		// start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \" appium -a 0.0.0.0 -p 4723 \"");
		//get address of appium server
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//provide device and app details
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion", "4.2.2");
		dc.setCapability("appPackage","com.android.deskclock");
		dc.setCapability("appActivity","com.android.deskclock.DeskClock");
		//create driver object to launch app in device
		AndroidDriver driver;
		while(2>1)  //infinite group
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception e)
			{
				
			}
		}
		// automate app screen elements
		try
		{
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		String x=driver.getCurrentPackage();
		System.out.println(x);
		String y=driver.currentActivity();
		System.out.println(y);
		
		// send app to background for 10 seconds 
		Duration d=Duration.of(10,ChronoUnit.SECONDS);
		driver.runAppInBackground(d);
		Thread.sleep(10000);
		
		// go to home 
		driver.pressKeyCode(AndroidKeyCode.HOME);
		Thread.sleep(5000);
		//Activate Calculator
		driver.launchApp();
		Thread.sleep(10000);
		//operate an element and reset app
		driver.findElement(By.xpath("//*[@text='9']")).click();
		Thread.sleep(5000);
		driver.resetApp();
		Thread.sleep(5000);
		//close app
		driver.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskKill /F /IM cmd.exe");
		
	}

}
