package com.week1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Softwares1\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		String	mainWindow=driver.getWindowHandle();
		System.out.println(mainWindow);
		driver.findElement(By.xpath("//*[text()='New Window']")).click();
		Thread.sleep(5000);
		Set<String>	windows=driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String	w1=it.next();
		String w2=it.next();		
		System.out.println(w1);
		System.out.println(w2);
		driver.switchTo().window(w2);
		String	childwValue=driver.findElement(By.id("sampleHeading")).getText();

		System.out.println(childwValue);
		driver.switchTo().window(w1);
		driver.switchTo().defaultContent();
		driver.close();

	}
}
