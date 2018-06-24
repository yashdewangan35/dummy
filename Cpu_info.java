package automation;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Cpu_info 
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
		
		//get performance details
		
		List<String> p1=driver.getSupportedPerformanceDataTypes();
		for(int l=0; l<p1.size(); l++)
		{
			System.out.print(p1.get(l)+ "\t");             //   \t=tab
		} 
		System.out.println();
		
		//get performance data 
		System.out.println("cpu information");
		List<List<Object>> ci=driver.getPerformanceData("com.google.android.apps.maps","cpuinfo",10000);
		for(int i=0; i<ci.size(); i++)
		{
			for(int j=0; j<ci.get(i).size(); i++)
			{
				try
				{
					System.out.print(ci.get(i).get(j).toString()+"\t");
				}
				catch(Exception e)
				{
					System.out.print(0);
				}
			}
		
			System.out.println("");
			//close app
			driver.closeApp();
		}
			
			//stop appium server
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskKill /F /IM cmd.exe");
			
		
		
		
		

	}

}
