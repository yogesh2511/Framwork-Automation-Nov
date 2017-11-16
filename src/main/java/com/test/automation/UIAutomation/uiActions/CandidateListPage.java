package com.test.automation.UIAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;

public class CandidateListPage extends TestBase
{	
	public static Logger log = Logger.getLogger(CandidateListPage.class.getName());

	public static WebElement getCandidateName(String name)
	{		
	/*	WebElement getCandidateName=null;
		try {
			getCandidateName = ElementLoaderObj.getWebElement("firstname", CandidateList);
			 log.info(getCandidateName.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getCandidateName;*/
		
		//ElementLoad().getWebElement("", fileName)
		return driver.findElement(By.xpath("//A[@class='fleft bgremove' and text()='"+name+"']"));
	}

	public static WebElement firstname()
	{
		WebElement Firstname=null;
		try {
			 Firstname = com.test.automation.UIAutomation.config.ElementLoad.getWebElement("firstname", CandidateListPropertyFile);
			 log.info(Firstname.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Firstname;
	}


	public static WebElement lastname()
	{
		WebElement lastname=null;
		try {
			lastname = com.test.automation.UIAutomation.config.ElementLoad.getWebElement("lastname", CandidateListPropertyFile);
			log.info(lastname.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastname;
	}

	public static WebElement email()
	{
		WebElement email=null;
		try {
			email = com.test.automation.UIAutomation.config.ElementLoad.getWebElement("email", CandidateListPropertyFile);
			log.info(email.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}

	public static WebElement contactnumber()
	{
		WebElement contactnumber=null;
		try {
			contactnumber = com.test.automation.UIAutomation.config.ElementLoad.getWebElement("ContactNumber", CandidateListPropertyFile);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contactnumber;
	}
	
	
	public static WebElement keyword()
	{
		WebElement advancedSearchText=null;
		try {
			advancedSearchText = com.test.automation.UIAutomation.config.ElementLoad.getWebElement("AdvancedSearchText", CandidateListPropertyFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return advancedSearchText;
	}

	public static WebElement zipcode()
	{
		WebElement zipcode=null;
		try {
			zipcode = com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Zipcode", CandidateListPropertyFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zipcode;
	}
	

	public static WebElement state()
	{
		WebElement state=null;
		try {
			state = com.test.automation.UIAutomation.config.ElementLoad.getWebElement("State", CandidateListPropertyFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}

	public static WebElement searchbtn()
	{
		WebElement searchbtn=null;
		try {
			searchbtn = com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Searchbtn", CandidateListPropertyFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchbtn;
	}
	
	public static WebElement within()
	{
		WebElement Within=null;
		try{
			Within=com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Within", CandidateListPropertyFile);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return Within;
	}
	
	public static WebElement searchBtnClick()
	{
		WebElement searchBtn=null;
		{
			try{
				searchBtn=com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Searchbtn", CandidateListPropertyFile);
				
			}catch(Exception e)
			{
				e.getMessage();
			}
		}
		return searchBtn;
	}
	public static WebElement resetBtnClick()
	{
		WebElement resetbtn=null;
		{
			try{
				resetbtn=com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Resetbtn", CandidateListPropertyFile);
				
			}catch(Exception e)
			{
				e.getMessage();
			}
		}
		return resetbtn;
	}
	
}
