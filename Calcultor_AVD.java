package automation;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Calcultor_AVD 
{
	public static void main(String[] args) throws Exception
	{           
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
				dc.setCapability("appPackage","com.android.calculator2");
				dc.setCapability("appActivity","com.android.calculator2.Calculator");
				
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
				try
				{
				driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
				
				//enter input 1
				
				for(int a=0; a<x.length(); a++)
				{
					char z=x.charAt(a);
					driver.findElement(By.xpath("//*[@text='"+z+"']")).click();
				}
				
				//click +
				
				driver.findElement(By.xpath("//*[@content-desc='plus']")).click();
				
				//enter input 2
				for(int i=0; i<y.length(); i++)
				{
					char z=y.charAt(i);
					driver.findElement(By.xpath("//*[@text='"+z+"']")).click();
					
				}
				
				//click=
				driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
				
				//get output
				String r=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getAttribute("text");
				int i1=Integer.parseInt(x);
				int i2=Integer.parseInt(y);
				int w=Integer.parseInt(r);
				if(w==i1+i2)
				{
					System.out.println("test passed");
				}
				else
				{
					System.out.println("test failed");
				}
				//close app
				driver.closeApp();
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
