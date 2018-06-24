package automation;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Calculator 
{
	public static void main(String[] args) throws Exception 
	{
		// start appium server
				Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \" appium -a 0.0.0.0 -p 4723 \"");
				//get address of appium server
				URL u=new URL("http://0.0.0.0:4723/wd/hub");
				
				//get data from keyboard
				Scanner sc=new Scanner (System.in);
				System.out.println("enter input 1");
				String x=sc.nextLine();
				System.out.println("enter input 2");
				String y=sc.nextLine();
				//provide device and app details
				DesiredCapabilities dc=new DesiredCapabilities();
				dc.setCapability(CapabilityType.BROWSER_NAME,"");
				dc.setCapability("deviceName","emulator-5554");
				dc.setCapability("platformName","android");
				dc.setCapability("platformVersion", "4.2.2");
				dc.setCapability("appPackage","com.android.calculator2");
				dc.setCapability("appActivity","com.android.calculator2.Calculator}");
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
				//Enter input1
				for(int i=0; i<x.length();i++)
				{
					char c = x.charAt(i);
					driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
					Thread.sleep(5000);
				}
				//click plus
				driver.findElement(By.xpath("//*[@content-desc='Plus']")).click();
				Thread.sleep(5000);
				
				//enter input2
				
				for(int i=0; i<y.length();i++)
				{
					char c = y.charAt(i);
					driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
					Thread.sleep(5000);
				}
				
				//get o/p
			    Thread.sleep(5000);
				String z=driver.findElement(By.xpath("//*[@class='android.widget.Button']")).getAttribute("=");
				String q=driver.findElement(By.xpath("//*[@resource-id='com.sec.android.app.popupcalculator:id/txtCalc_RealTimeResult']")).getText();
				System.out.println(q);
				//validate o/p
				try
				{
				int a=Integer.parseInt(x);
				int b=Integer.parseInt(y);
				int c=Integer.parseInt(z);
				if(c==a+b)
				{
					System.out.println("addition not passed");
				}
				else
				{/*
					System.out.println("addition test failed");
					DateFormat df=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
					Date d=new Date();
					String imagename=df.format(d);
					File src=driver.getScreenshotAsOutputType.FILE();
					File dest=new File("E:\\batch237\\"+imagename+".png");
					FileUtils.copyFile(src,dest);
					*/
				}
				}
				catch(NumberFormatException e)
				{
					
				}
				
					
				//stop appium server
				Runtime.getRuntime().exec("taskkill /F /IM node.exe");
				Runtime.getRuntime().exec("taskKill /F /IM cmd.exe");
				
				
	}

}
