package automation;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Message_app_ard
{
	public static void main(String[] args) throws Exception 
	{
		/*
		//Sceanrio
		Lauch app in app in ard 
		click on search 
		hide keyboard if exsist
		close app*/

        // get data from keyboard
         Scanner sc=new Scanner(System.in);
         System.out.println("enter input 1");
         String x=sc.nextLine();
         System.out.println("enter input 2");
         String y=sc.nextLine();
         
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
		AndroidDriver driver = null;
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
			
			// automate app screen elements
			try
			{
				driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
				driver.findElement(By.xpath("//[@content-desc='More Options']")).click();
				Thread.sleep(5000); // not req
				driver.findElement(By.xpath("//*[@text='Search']")).click();
				if(driver.isKeyboardShown())
				{
					driver.hideKeyboard();
				}
				else
				{
					System.out.println("No keyboard, try to get");
					driver.getKeyboard();
				}
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

}
