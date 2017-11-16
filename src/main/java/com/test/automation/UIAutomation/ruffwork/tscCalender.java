package com.test.automation.UIAutomation.ruffwork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.test.automation.UIAutomation.testBase.TestBase;

public class tscCalender extends TestBase {

	
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\yogeshsolanki\\Desktop\\Selenium Test Setup\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();*/
		
		
		/*driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        //To maximize the browser
		driver.manage().window().maximize();
        //Create an object 'action' of an Actions class
		Actions action = new Actions(driver);
		By locator = By.cssSelector(".context-menu-one");
        //Wait for the element. Used Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 
        WebElement rightClickElement=driver.findElement(locator);
        //contextClick() method to do right click on the element
        action.contextClick(rightClickElement).build().perform();
        WebElement getCopyText =driver.findElement(By.cssSelector(".context-menu-icon-Viev Image"));
        //getText() method to get the text value
        String GetText = getCopyText.getText();
        //To print the value
        System.out.println(GetText);*/
		
		String url="http://192.168.1.160:5555/wd/hub";
		DesiredCapabilities capabilitis=new DesiredCapabilities().chrome();
		capabilitis.setBrowserName("chrome");
		capabilitis.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		//driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("http://jqueryui.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='sidebar']/aside[4]/ul/li[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='content']/div[1]/ul/li[2]/a")).click();
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame1);
		Thread.sleep(5000);
		WebElement image = driver.findElement(By.xpath("//*[@id='container']/img[2]"));
		//Actions action= new Actions(driver);
		Actions action= new Actions(driver);
		action.contextClick(image).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		//action.contextClick(image).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		//action.sendKeys(Keys.CONTROL).sendKeys(Keys.SHIFT).sendKeys(Keys.chord("I")).build().perform();
		
		 WebElement getCopyText =driver.findElement(By.cssSelector(".context-menu-icon-Inspect"));
	        //getText() method to get the text value
	        String GetText = getCopyText.getText();
	        //To print the value
	        System.out.println(GetText);
		
		/*
		 List<WebElement> selectHeadr = driver.findElements(By.xpath("//h3[@role='tab']"));
		
		List<WebElement> paragraph= driver.findElements(By.xpath("//div[@role='tabpanel']/p"));
		for(WebElement e: selectHeadr)
		{
			System.out.println("Header:"+e.getText());
			e.click();
			for(WebElement s:paragraph)
			{
				System.out.println("paragraph: "+s.getText());
				
			}
		}*/
		
	/*	WebElement source=driver.findElement(By.xpath(".//*[@id='sortable']/li[1]"));
		System.out.println("source:"+source.getLocation());
		WebElement target=driver.findElement(By.xpath(".//*[@id='sortable']/li[5]"));
		System.out.println("destination:"+target.getLocation());
	*/	//act.dragAndDrop(source, target).release().build().perform();
		
		//act.clickAndHold(source).moveByOffset(11, 253).release().build().perform();
		//act.dragAndDropBy(source, 11, 253).release().build().perform();
		/*List<WebElement> allList=driver.findElements(By.xpath(".//*[@id='selectable']/li"));
		 List<String> selectElement= new ArrayList<String>();
				 
		 selectElement.add("Item 4");
		 selectElement.add("Item 7"); 
		
		for(int i=0;i<=6;i++)
		{
			System.out.println("allList:"+allList.size());
			System.out.println("selectElement:"+selectElement.size());
			
		
				if(allList.get(i).getText().equals("Item 4"))
				{
					act.click(allList.get(i)).keyDown(Keys.CONTROL).build().perform();
				}
		
		}*/
		//System.out.println(driver.findElement(By.xpath(".//*[@id='draggable']")).getText());
	/*	WebElement source = driver.findElement(By.xpath(".//*[@id='resizable']/div[4]"));
		System.out.println("source: "+source.getLocation());*/
		/*WebElement target=driver.findElement(By.xpath(".//*[@id='droppable']"));
		System.out.println("target: "+target.getLocation());*/
		
		//act.clickAndHold(source).moveByOffset(145, 78).release().build().perform();
		//act.dragAndDropBy(source, 162, 24).build().perform();
		//act.dragAndDrop(source, target).build().perform();
		//act.dragAndDropBy(source, 154, 100).build() .perform();
		
		/*driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[2]/a")).click();
		driver.switchTo().frame(frame1);
		
		
		act.dragAndDropBy(source, 154, 100).build() .perform();*/
		
		/*Actions act=new Actions(driver);
		act.clickAndHold(source);
		//act.clickAndHold();
		//act.moveToElement(source, 100, 0);
		act.moveByOffset(255, 67);
		act.build().perform();*/
		
		
		
		
		
		/*List<WebElement> listofElement = driver.findElements(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li"));
		for(WebElement list: listofElement)
		{
			System.out.println(list.getText());
			if(list.getText().equals("Draggable"))
			{
				list.click();
				WebElement dragableElement = driver.findElement(By.xpath("//div[@id='draggable']"));
				Actions act=new Actions(driver);
				
				Action mouseOverHome = act
                        .moveToElement(dragableElement)
                        .build();
				
				act.moveToElement(dragableElement).build().perform();
				
			}
		}*/
		/*driver.findElement(By.xpath("//INPUT[@id='UserEmail']")).sendKeys("shahinrana@ranagam.com");
		driver.findElement(By.xpath("//INPUT[@id='UserPassword']")).sendKeys("123@Rana");
		driver.findElement(By.xpath("//INPUT[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//A[@id='post']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='txtJobAnnounced']")).click();
		Thread.sleep(2000);
		
		Select years = new Select(driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]")));
		years.selectByVisibleText("2021");
		Thread.sleep(2000);
		Select months = new Select(driver.findElement(By.xpath("//SELECT[@class='ui-datepicker-month']")));
		months.selectByVisibleText("Oct");

		Thread.sleep(2000);

	
	  List<WebElement> dates = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr/td/a"));
	  for(WebElement date: dates)
		{
			System.out.println(date.getText());
			if(date.getText().equals("10"))
			{
				date.click();
				break;
			}
		}*/

	}
	
	

}
