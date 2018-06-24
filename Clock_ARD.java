package automation;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Clock_ARD
{
	private static int startPercentage;
	private static int finalPercentage;

	public static void main(String[] args) throws IOException, Exception 
	{
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \" appium -a 0.0.0.0 -p 4723 \"");
		//get address of appium server
		
		URL u= new URL("http", "0.0.0.0", 4723, "/wd/hub");
		
		//provide device and app details
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","192.168.1.27:5555");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("appPackage","com.sec.android.app.clockpackage");
		dc.setCapability("appActivity","com.sec.android.app.clockpackage.ClockPackage");
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
		TouchAction ta=new TouchAction(driver);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@text='WORLD CLOCK']")).click();
		driver.findElement(By.xpath("//*[@text='Local time zone']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@bounds='[54,234][888,342]']")).click();
		Thread.sleep(5000);
		
		org.openqa.selenium.Dimension size=driver.manage().window().getSize();
		Thread.sleep(5000);

		int width=(int)(size.width/2);   //right
		int startPoint = (int) (size.getHeight() * startPercentage);
		int endPoint = (int) (size.getWidth() * 1.9);
		Thread.sleep(5000);
		//WebElement e1=driver.findElement(By.xpath("//*[@bounds='[0,1212][1080,1400]']"));
		ta.press(width, startPoint).waitAction(Duration.ofMillis(5000)).moveTo(width,endPoint).release().perform();
	
		
		
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskKill /F /IM cmd.exe");

	}

}
