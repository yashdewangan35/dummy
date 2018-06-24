package automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Data_connect_mobile 
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
				
			//Check wifi connection 
				Connection c=driver.getConnection();
				if(c.compareTo(Connection.AIRPLANE)==0)
				{
					System.out.println("airplane mode is on");
				}
				else
				{
					System.out.println("airplane is off");
				}
				if(c.compareTo(Connection.DATA)==0)
				{
					System.out.println("data is on");
				}
				else
				{
					System.out.println("data is off");
				}
				if (c.compareTo(Connection.WIFI)==0)
				{
					System.out.println("wifi is on");
				}
				else
				{
					System.out.println("wifi is off");
					driver.setConnection(Connection.WIFI);
				}
				
				//close app
				driver.close();
				
				
				//stop appium server
				Runtime.getRuntime().exec("taskkill /F /IM node.exe");
				Runtime.getRuntime().exec("taskKill /F /IM cmd.exe");
	}

}
