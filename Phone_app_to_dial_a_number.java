package automation;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Phone_app_to_dial_a_number 
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
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage","com.android.contacts");
		dc.setCapability("appActivity","com.android.contacts.activities.DialtactsActivity");
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
		
		Thread.sleep(5000);
		try
		{
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		String x="9945741061";
		for(int i=0; i<x.length(); i++)
		{
			char y=x.charAt(i);
			Thread.sleep(5000);
			String z="";
			switch(y)
			{
			case '0':
			z="zero";
			break;
			
			case '1':
		    z="one";
		    break;
		    
			case '2':
			z="two";
			break;
			
			case '3':
			z="three";
		    break;
		    
			case '4':
			z="four";
			break;
			
			case '5':
		    z="five";
	        break;
	        
			case '6':
			z="six";
			break;
			
			case '7':
			z="seven";
			break;
			
			case '8':
			z="eight";
			break;
			
			case '9':
			z="nine";
			break;
			
			default:
		    System.out.println("wrong digit");
		    break;
			}
			
			driver.findElement(By.xpath("//*[@content-desc='"+z+"']")).click();
			Thread.sleep(5000);
			
		}
		  WebDriverWait w = new WebDriverWait(driver, 100);
		  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='dial']"))).isDisplayed();
				
		  driver.findElement(By.xpath("//*[@content-desc='dial']")).click();
		  Thread.sleep(10000);
		  
		  driver.findElement(By.xpath("//*[@content-desc='End']")).click();
		  Thread.sleep(5000);

		  
		}
	
	     catch(Exception e)
	     {
	    	 System.out.println(e.getMessage());
	     }
			//close app
			driver.closeApp();
			
			
			//stop appium server
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskKill /F /IM cmd.exe");
			
	}

}
