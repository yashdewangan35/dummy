package automation;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Video_call 
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
				dc.setCapability("deviceName","PLEGAR1771408671");
				dc.setCapability("platformName","android");
				dc.setCapability("platformVersion", "8.1.0");
				dc.setCapability("appPackage","com.whatsapp");
				dc.setCapability("appActivity","com.whatsapp.HomeActivity");
				
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
				/*WebDriverWait w=new WebDriverWait(driver,100);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.LinearLayout']")));
				driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout']")).click();*/
					
				
				
				Runtime.getRuntime().exec("taskkill /F /IM node.exe");
				Runtime.getRuntime().exec("taskKill /F /IM cmd.exe");
				

	}

}
