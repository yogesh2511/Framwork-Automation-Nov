package com.test.automation.UIAutomation.ruffwork;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.UIAutomation.testBase.TestBase;
import com.test.automation.UIAutomation.uiActions.NewRequirement;
import com.test.automation.UIAutomation.uiActions.Pages;

public class DataExcel extends TestBase
{

	@DataProvider(name = "RegisterDetailsTestData")
	public String[][] getTestData2() {
		//String[][] testRecords = getData("TestData.xlsx", "LoginTestData");
		String[][] testRecords = getData(Config.getProperty("exelsheetname"), Config.getProperty("RegisterDetailsTestData"));
		//return getData("TestData.xlsx","RegisterDetailsTestData");
		return testRecords;
	}	
	
	
	@Test(dataProvider="RegisterDetailsTestData", dependsOnMethods={"SelectHeader"},enabled=true,alwaysRun=true)
	public static void fillRequirement(String ClientJobCode,String JobTitle,String JobType,String VisaType,String NoticePeriod,String LOB,String SkillType,String ReqStatus,String Duration,
			String ASAP,String OpenDate,String CloseDate,String DueDate,String Position,String ActualSlots,String Addressline1,String State,String City,String Pincode,String ShiftTimeFrom ,String ShiftTimeTo,
			String WeeklyHours,String InterviewStartDate,String InterviewEndDate,String RecruiterRequirementManager,String RecruiterTeamLeader,String ConfirmationRequirementManager,
			String ConfirmationTeamLeader,String ClientInformationCategory,String ClientInformationClient,String BillRateFromclient,String ClientInformationPayRate,
			String ClientInformationRateType,String VMSManager,String JobDescription,String skill1,String skill2,String skill3,String skill4,String subject,String runMode)
	{	
		
		if (runMode.equalsIgnoreCase("n")) {
			log.info("RegisterDetailsTestData skipped methods");
			test = extent.startTest("verifiy skipped methods");
			test.log(LogStatus.INFO, "verifiy skipped methods");
			test.log(LogStatus.SKIP, "Registeration details skipped");
			throw new SkipException("Skipping this exception");

		}
		
		
		
		else{
		
		test = extent.startTest("Fill Requirement Details");		
		try {	
			test.log(LogStatus.INFO, "Requirement Details");
			Pages.NewRequirement();
			NewRequirement.fillAllRequirementInformation(ClientJobCode, JobTitle, JobType, VisaType, NoticePeriod, LOB, SkillType, ReqStatus, Duration,
					 ASAP, OpenDate, CloseDate, DueDate, Position, ActualSlots,Addressline1,State,City,Pincode,ShiftTimeFrom,ShiftTimeTo,WeeklyHours,InterviewStartDate,InterviewEndDate,RecruiterRequirementManager,
					 RecruiterTeamLeader,ConfirmationRequirementManager,ConfirmationTeamLeader,ClientInformationCategory,ClientInformationClient,BillRateFromclient,
					 ClientInformationPayRate,ClientInformationRateType,VMSManager,JobDescription,skill1,skill2,skill3,skill4,subject);
			
			test.log(LogStatus.INFO, "ClientJobCode:"+ClientJobCode+"\t"+" JobTitle: "+JobTitle+"\t"+" JobType : "+JobType+"\t"+" VisaType :"+VisaType+"\t"+" NoticePeriod: "+NoticePeriod+"\t"+" LOB: "+ LOB+"\t"+ " SkillType: "+SkillType+"\t"+ " ReqStatus: "+ReqStatus+"\t"+ " Duration :"+Duration+"\t");
			test.log(LogStatus.INFO, "ASAP:"+ASAP+"\t"+" OpenDate: "+OpenDate+"\t"+" CloseDate : "+CloseDate+"\t"+" DueDate :"+DueDate+"\t"+" Position: "+Position+"\t"+" ActualSlots: "+ ActualSlots+"\t"+ " Addressline1: "+Addressline1+"\t"+ " Pincode: "+Pincode+"\t"+ " ShiftTimeFrom :"+ShiftTimeFrom+"\t");
			test.log(LogStatus.INFO, "ShiftTimeTo:"+ShiftTimeTo+"\t"+" WeeklyHours: "+WeeklyHours+"\t"+" InterviewStartDate : "+InterviewStartDate+"\t"+" InterviewEndDate :"+InterviewEndDate+"\t"+" RecruiterRequirementManager: "+RecruiterRequirementManager+"\t"+" RecruiterTeamLeader: "+ RecruiterTeamLeader+"\t"+ " ConfirmationRequirementManager: "+ConfirmationRequirementManager+"\t"+ " ConfirmationTeamLeader: "+ConfirmationTeamLeader+"\t"+ " ClientInformationCategory :"+ClientInformationCategory+"\t");
			test.log(LogStatus.INFO, "ClientInformationClient:"+ClientInformationClient+"\t "+" BillRateFromclient: "+BillRateFromclient+"\t "+" ClientInformationPayRate : "+ClientInformationPayRate+"\t"+" ClientInformationRateType :"+ClientInformationRateType+"\t"+" VMSManager: "+VMSManager+"\t"+" JobDescription: "+ JobDescription+"\t"+ " skill1: "+skill1+ "\t"+" skill2: "+skill2+"\t"+ " skill3 :"+skill3+"\t"+ " skill4: "+skill4+ "\t"+" subject :"+subject+"\t");
			test.log(LogStatus.INFO, "fill All RequirementInformation Details");
			
		} 
		catch (Exception e) 
			{
				log.info(e.getMessage());
			}
		}
		}	
}
