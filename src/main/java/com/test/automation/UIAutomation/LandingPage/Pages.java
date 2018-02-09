package com.test.automation.UIAutomation.LandingPage;

import org.openqa.selenium.support.PageFactory;

import com.test.automation.UIAutomation.LoginPage.LoginPage;
import com.test.automation.UIAutomation.testBase.TestBase;
import com.test.automation.UIAutomation.uiActions.Candidates.NewCandidatePage;
import com.test.automation.UIAutomation.uiActions.Candidates.AssignCandidatePage;
import com.test.automation.UIAutomation.uiActions.Candidates.CandidateListPage;
import com.test.automation.UIAutomation.uiActions.Requirements.NewRequirement;
import com.test.automation.UIAutomation.uiActions.Requirements.RequirementDetailsPage;
import com.test.automation.UIAutomation.uiActions.Requirements.UpdateRegisterationdetailsPage;
import com.test.automation.UIAutomation.uiActions.Dashboard.DashboardAdminHeaderPage;

public class Pages extends TestBase
{
	
	public Pages()
	{
		PageFactory.initElements(driver, this);		
	}
	
	public static HomePage homapage()
	{
		return PageFactory.initElements(driver, HomePage.class);
		
	}
	
	public static LoginPage loginpage()
	{
		return PageFactory.initElements(driver, LoginPage.class);
		
	}
	
	public static CandidateListPage candidatelist()
	{
		return PageFactory.initElements(driver, CandidateListPage.class);
	}
	
	public static NewCandidatePage CandidateDetails()
	{
		return PageFactory.initElements(driver, NewCandidatePage.class);
	}
	
	public static RequirementDetailsPage RequirementDetails()
	{
		return PageFactory.initElements(driver,RequirementDetailsPage.class);
	} 

	public static NewRequirement NewRequirement()
	{
		return PageFactory.initElements(driver,NewRequirement.class);
	} 
	public static UpdateRegisterationdetailsPage UpdateRegisterationdetailsPage()
	{
		return PageFactory.initElements(driver,UpdateRegisterationdetailsPage.class);
	} 	
		
	public static AssignCandidatePage AssignCandidatePage()
	{
		return PageFactory.initElements(driver,AssignCandidatePage.class);
	} 	
	
	public static DashboardAdminHeaderPage DashboardAdminHeaderPage()
	{
		return PageFactory.initElements(driver,DashboardAdminHeaderPage.class);
		
	}
}
