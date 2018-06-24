package automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Software_info 
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
				dc.setCapability("locationServicesEnabled", true);
				dc.setCapability("locationServicesAuthorized", true);
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
				}
				
				// go to home
				driver.pressKeyCode(AndroidKeyCode.HOME);
				Thread.sleep(5000);
				
				//get appium server address
				String y=driver.getRemoteAddress().getPath();
				System.out.println(y);
				
				String z=driver.getRemoteAddress().getProtocol();
				System.out.println(z);

				int p=driver.getRemoteAddress().getPort();
				System.out.println(p);

				String q=driver.getRemoteAddress().getHost();
				System.out.println(q);
				
	            Long w=driver.getDisplayDensity();
				System.out.println(w);
				
				String a=driver.getDeviceTime();
				System.out.println(a);
				
				String b=driver.getPlatformName();
				System.out.println(b);
				Thread.sleep(5000);
				
				//get version of android in device
				driver.openNotifications();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@content-desc='open settings")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@text='About Phone']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@text='Software Information']")).click();
				Thread.sleep(5000);
				String d=driver.findElement(By.xpath("//*[@bound='[48,216][131,252]']")).getAttribute("text");
				System.out.println(d);
				driver.pressKeyCode(AndroidKeyCode.HOME);
				Thread.sleep(5000);
				driver.launchApp();
				driver.closeApp();
				
				//stop appium server
				Runtime.getRuntime().exec("taskkill /F /IM node.exe");
				Runtime.getRuntime().exec("tskkill /F /IM cmd.exe");
				
				
				
		
			
	}

}
