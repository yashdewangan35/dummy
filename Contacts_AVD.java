package automation;

import io.appium.java_client.android.AndroidDriver;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Contacts_AVD
{
	public static void main(String[] args) throws Exception
	{
		
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
				dc.setCapability("appPackage","com.android.contacts");
				dc.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");
				
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
				
	WebDriverWait w=new WebDriverWait(driver,100);
	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Add Contact']")));
	driver.findElement(By.xpath("//*[@content-desc='Add Contact']")).click();
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//*[@text='Keep local']")).click();
	
	
	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Name']")));
	
	
	
	driver.findElement(By.xpath("//*[@text='Name']")).sendKeys(x);
	Thread.sleep(5000);

	
	driver.findElement(By.xpath("//*[@class='android.widget.EditText'][@text='Phone']")).sendKeys(y);
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//*[@bounds='[0,50][228,146]']")).click();
	Thread.sleep(10000);
	
	//close app
	driver.closeApp();
	//stop appium server
	Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	Runtime.getRuntime().exec("taskKill /F /IM cmd.exe");
	}
}
