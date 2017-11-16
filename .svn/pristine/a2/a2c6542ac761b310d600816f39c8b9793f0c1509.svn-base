package com.test.automation.UIAutomation.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.test.automation.UIAutomation.testBase.TestBase;


public class PropertiesfilesLoad extends TestBase
{
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fConfig;
	public static void propertiesFilesLoad(String propertyFileName) 
	{
		//Properties propertyfile = null;
		try 
		{
			fConfig = new FileInputStream(
					System.getProperty("user.dir") + "//resources//properties//+'"+propertyFileName+"'");
			Config.load(fConfig);
			log.debug("Config File Loading"+fConfig);
			/*fOR = new FileInputStream(
					System.getProperty("user.dir") + "//resources//properties//OR.properties");
			OR.load(fOR);
			log.debug("OR File Loading");
			fhomepage = new FileInputStream(
					System.getProperty("user.dir") + "//resources//properties//homepage.properties");
			hompagePropertyFile.load(fhomepage);
			floginpage = new FileInputStream(
					System.getProperty("user.dir") + "//resources//properties//LoginPage.properties");
			loginPropertyFile.load(floginpage);
			log.debug("login property File Loaded sucessfully");
			log.debug("Config File Loading");*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
