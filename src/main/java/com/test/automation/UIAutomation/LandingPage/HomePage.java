package com.test.automation.UIAutomation.LandingPage;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.test.automation.UIAutomation.config.ElementLoad;
import com.test.automation.UIAutomation.testBase.TestBase;
import com.test.automation.UIAutomation.uiActions.Requirements.RequirementDetailsPage;

public class HomePage extends TestBase {

	public static Logger log = Logger.getLogger(HomePage.class.getName());

	// public static List<WebElement> Allmenus = new ArrayList<>();
	public static List<WebElement> AllHeaderMenuslinks = null;
	public static List<WebElement> AllHeaderSubMenuLinks = null;
	public static List<WebElement> AllRequirementlinks = null;
	public static String requirmentDetailsPage = null;

	public static void serachKeyword(String keyword) {
		try {
			log.info("**************serachKeyword method startd*******************");
			WebElement searchKeywors = ElementLoad.getWebElement("Requirements", hompagePropertyFile);
			log.info(searchKeywors);

			sendKeys(searchKeywors, keyword);
			log.info("searchKeywors entered" + keyword);
			click(ElementLoad.getWebElement("SearchBtn", hompagePropertyFile));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static WebElement Requirements() throws Exception {
		WebElement Requirements = null;
		try {
			Requirements = ElementLoad.getWebElement("Requirements", hompagePropertyFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Requirements;
	}

	public static WebElement requirementList() {
		WebElement RequirementList = null;
		try {
			RequirementList = ElementLoad.getWebElement("RequirementList", hompagePropertyFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RequirementList;

	}

	public static void allHeaderMenu() {
		try {
			
			AllHeaderMenuslinks = ElementLoad.getWebElements("Mainheader", hompagePropertyFile);
			// log.info("AllHeaderMenuslinks:"+AllHeaderMenuslinks);
			// singleHeaderMethod(Header);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void singleHeaderMethod(String Header) {
		allHeaderMenu();
		try {
			for (int i = 0; i < AllHeaderMenuslinks.size(); i++) {

				String SingleHeader = AllHeaderMenuslinks.get(i).getText();
				// log.info("subElement:"+subElement);
				if (SingleHeader.equalsIgnoreCase(Header)) {
					click(AllHeaderMenuslinks.get(i));
					break;
					// log.info("****************equalsIgnoreCase
					// display*********"+Header);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void allSubHeaderMenu(String Header) {
		singleHeaderMethod(Header);
		try {
			// log.info("****************try*********");
			AllHeaderSubMenuLinks = ElementLoad.getWebElements("submenu", hompagePropertyFile);
			log.info("AllHeaderMenuslinks:" + AllHeaderMenuslinks.size());
			// singleHeaderMethod(Header);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public static void subHeaderMethod(String Header, String subHeader) {
		allSubHeaderMenu(Header);
		try {
			for (int i = 0; i < AllHeaderSubMenuLinks.size(); i++) {

				String SingleHeader = AllHeaderSubMenuLinks.get(i).getText();
				log.info("subElement:" + SingleHeader);
				if (SingleHeader.equalsIgnoreCase(subHeader)) {
					click(AllHeaderSubMenuLinks.get(i));
					break;

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static WebElement priorityCheck() {
		WebElement prioritydropdown = null;
		try {
			prioritydropdown = com.test.automation.UIAutomation.config.ElementLoad.getWebElement("PriorityDropdown",
					hompagePropertyFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prioritydropdown;
	}

	public static WebElement selectPageSize() {
		WebElement selectPageSizedropdown = null;
		try {
			selectPageSizedropdown = com.test.automation.UIAutomation.config.ElementLoad.getWebElement("PageSize",
					hompagePropertyFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectPageSizedropdown;
	}

	public static void selecByColorPriority() {
		try {
			// log.info("****************try*********");
			AllRequirementlinks = com.test.automation.UIAutomation.config.ElementLoad
					.getWebElements("RequirementTotalList", hompagePropertyFile);
			// log.info("AllRequirementlinks:"+AllRequirementlinks.size());
			// singleHeaderMethod(Header);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void singleSelecBbyColor(String color) {

		selecByColorPriority();

		try {
			for (int i = 0; i < AllRequirementlinks.size(); i++) {
				String SingleHeader = AllRequirementlinks.get(i).getAttribute("style");

				String[] colorsdetails = SingleHeader.split(":");

				for (String colors : colorsdetails) {
					// log.info("colorsdetails:" + colorsdetails[i].toString());
					log.info("colors:" + colors);
					if (color.equalsIgnoreCase(colors)) {
						log.info("pink color");

						swapToRequirementDetailsPage(AllRequirementlinks.get(i));

						// AllRequirementlinks.get(i).click();
						// break;
					} else if (color.equalsIgnoreCase(colors)) {
						log.info("orange color" + AllRequirementlinks.get(i));
						swapToRequirementDetailsPage(AllRequirementlinks.get(i));
						// return colorslist=orange;
						// AllRequirementlinks.get(i).click();
						// break;
						// log.info(w.length());
					} else if (color.equalsIgnoreCase(colors)) {
						log.info("light green color color" + AllRequirementlinks.get(i));
						swapToRequirementDetailsPage(AllRequirementlinks.get(i));
						// return colorslist=lemongreen;
						// AllRequirementlinks.get(i).click();
						// break;
						// log.info(w.length());
					} else if (color.equalsIgnoreCase(colors)) {
						log.info("red color color" + AllRequirementlinks.get(i));
						swapToRequirementDetailsPage(AllRequirementlinks.get(i));
						// return colorslist=red;
						// AllRequirementlinks.get(i).click();
						// break;
						// log.info(w.length());
					}

					else {
						log.info("color not found");
					}
				}

				/*
				 * if(SingleHeader.equalsIgnoreCase(color)) {
				 * click(AllHeaderMenuslinks.get(i)); break; //log.info(
				 * "****************equalsIgnoreCase display*********"+Header);
				 * }
				 */
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return colorslist;
	}

	public static void swapToRequirementDetailsPage(WebElement element) throws InterruptedException {
		String winHandleBefore = driver.getWindowHandle();
		log.info("winHandleBefore: " + winHandleBefore);
		click(element);
		// Perform the click operation that opens new window
		ArrayList<String> window = new ArrayList<String>();

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			log.info("winHandle: " + winHandle);
		}

		log.info(" currnt winHandle: " + driver.getWindowHandle());
		log.info("Title:" + driver.getTitle());
		// requirmentDetailsPage= driver.getWindowHandle();

		Pages.RequirementDetails();
		// SwaptoOtherPage();
		RequirementDetailsPage.selectHeader("Requirement Details");
		// Perform the actions on new window
		Thread.sleep(5000);
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		// log.info("winHandleBefore: "+winHandleBefore);

	}

	public static void SwaptoOtherPage() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			log.info("winHandle: " + winHandle);
		}

		log.info(" currnt winHandle: " + driver.getWindowHandle());
		log.info("Title:" + driver.getTitle());
	}

	@Test
	public static String selectColor(String color) {
		String col = "";
		if (color.equalsIgnoreCase("pink")) {
			col = new String(" rgb(232, 69, 181);");
			singleSelecBbyColor(col);
			log.info("Color: " + col);
		} else if (color.equalsIgnoreCase("orange")) {
			col = new String(" rgb(248, 148, 6);");
			singleSelecBbyColor(col);
			log.info("Color: " + col);
		} else if (color.equalsIgnoreCase("light green")) {
			col = new String(" rgb(189, 185, 37);");
			singleSelecBbyColor(col);
			log.info("Color: " + col);
		} else if (color.equalsIgnoreCase("red")) {
			col = new String(" rgb(255, 0, 0);");
			singleSelecBbyColor(col);
			log.info("Color: " + col);
		} else {
			log.info("colors not found");
		}
		return col;
	}

	/*public static void selectDashboard() {
		try {
			driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void selectCandidateList()
	{
		try {
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Candidates')]"))).build().perform();
			act.click(driver.findElement(By.xpath("//a[contains(text(),'Candidate List')]"))).click().build().perform();;
			//driver.findElement(By.xpath("//a[contains(text(),'Candidates')]")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void selectCareerSiteCandidate()
	{
		try {
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Candidates')]"))).build().perform();
			act.click(driver.findElement(By.xpath("//a[contains(text(),'Career Site Candidate')]"))).click().build().perform();;
			//driver.findElement(By.xpath("//a[contains(text(),'Candidates')]")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void selectNewCandidate()
	{
		try {
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Candidates')]"))).build().perform();
			act.click(driver.findElement(By.xpath("//a[contains(text(),'New Candidate')]"))).click().build().perform();;
			//driver.findElement(By.xpath("//a[contains(text(),'Candidates')]")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void selectMonsterSearch()
	{
		try {
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Candidates')]"))).build().perform();
			act.click(driver.findElement(By.xpath("//a[contains(text(),'Monster Search')]"))).click().build().perform();;
			//Import Candidate
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void selectImportCandidate()
	{
		try {
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Candidates')]"))).build().perform();
			act.click(driver.findElement(By.xpath("//a[contains(text(),'Import Candidate')]"))).click().build().perform();;
			//Import Candidate
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void selectMonsterInventoryReport()
	{
		try {
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Candidates')]"))).build().perform();
			act.click(driver.findElement(By.xpath("//a[contains(text(),'Monster Inventory Report')]"))).click().build().perform();;
			//Resume Inventory Report
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void selectResumeInventoryReport()
	{
		try {
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Candidates')]"))).build().perform();
			act.click(driver.findElement(By.xpath("//a[contains(text(),'Resume Inventory Report')]"))).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
}
