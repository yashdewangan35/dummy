package automation;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Clock_AVD 
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
			catch(Exception ex)
			{
				
			}
		}
		
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Cities']")));
		driver.findElement(By.xpath("//*[@content-desc='Cities']")).click();
		Thread.sleep(5000);
		
		int v = driver.manage().window().getSize().getWidth();
		int h = driver.manage().window().getSize().getHeight();
		driver.context("NATIVE_APP");
		
		TouchAction ta = new TouchAction(driver);
        
		// swipe from bottom to top 
		int c=(int)(v/2);   //right
		int d=(int)(h*0.9);
		int temp=(int)(h*0.7); // left
		
		/*TouchAction ts = new TouchAction(driver);
		ts.press(207, 2000).moveTo(8, -360).release().perform();
*/
		while(2>1)

		{
			try
			{
				driver.findElement(By.xpath("//*[@text='Delhi']")).click();
				break;
			}
			catch(Exception ex)
			{
			 
				ta.press(c,d).moveTo(0,temp-d).release().perform();
				Thread.sleep(5000);

			}
		}
		
		
		
	}

}
