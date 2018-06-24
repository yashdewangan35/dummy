package automation;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Longitude_latitude_altitude 
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
						
						//set location to banguluru
						Location l1=new Location(12.971599, 77.594566,2000);
						driver.setLocation(l1);
						Thread.sleep(5000);
						
						//set location to tajmahal
						Location l2=new Location(27.1750,78.0422,2000);
						driver.setLocation(l2);
						Thread.sleep(5000);
						driver.closeApp();
						
						//stop appium server
						Runtime.getRuntime().exec("taskkill /F /IM node.exe");
						Runtime.getRuntime().exec("taskKill /F /IM cmd.exe");
						
					
	}

}
