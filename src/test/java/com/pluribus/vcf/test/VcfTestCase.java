//package com.pluribus.vcf.test;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.AssertJUnit;
//import org.testng.annotations.Test;
//
//import com.beust.jcommander.Parameters;
//import com.pluribus.vcf.pagefactory.VCFHomePage;
//import com.pluribus.vcf.pagefactory.VCFLoginPage;
//
//import junit.framework.Assert;
//
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.BeforeClass;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.AfterSuite;
//
//
//public class VcfTestCase {
//
//	WebDriver driver;
//	VCFLoginPage objLogin;
//	VCFHomePage objHomePage;
//    private String url = "https://10.9.10.112";
//    private String password = "test123";
//    private String username ="admin";
//
////	@Test
////	public void firstLogin() {
////		url = "https://10.9.10.112";
////		objLogin = new VCFLoginPage(driver,url);
////		//Verify login page title
////		String loginPageTitle = objLogin.getLoginTitle();
////		System.out.println( loginPageTitle);
////		AssertJUnit.assertEquals(loginPageTitle, "VCF Insight Analytics");
////		//login to application
////		objLogin.firstlogin("admin", "test123");
////		// go the next page
////		objHomePage = new VCFHomePage(driver);
////		System.out.println(objHomePage.getCurrentURL());
////		objHomePage.logout();
////	}
//	
//	@Test//(dependsOnMethods = { "firstLogin" })
//	public void verifyLogin() {
//		url = "https://10.9.10.112";
//		objLogin = new VCFLoginPage(driver,url);
//		//Verify login page title
//		String loginPageTitle = objLogin.getLoginTitle();
//		System.out.println( loginPageTitle);
//		AssertJUnit.assertEquals(loginPageTitle, "VCF Insight Analytics");
//		//login to application
//		objLogin.login("admin", "test123");
//		// go the next page
//		objHomePage = new VCFHomePage(driver);
//		System.out.println(objHomePage.getCurrentURL());
//		objHomePage.logout();
//	}
//	
//	@Test(dependsOnMethods = { "verifyLogin" })
//	public void test_LoginAndBrowsePAandIAPages() throws InterruptedException{
//		//Create Login Page object
//	String url ="https://10.9.10.112";
//	objLogin = new VCFLoginPage(driver,url);
//	//Verify login page title
//	String loginPageTitle = objLogin.getLoginTitle();
//	System.out.println( loginPageTitle);
//	Assert.assertEquals(loginPageTitle, "VCF Insight Analytics");
//	//login to application
//	objLogin.login("admin", "test123");
//	// go the next page
//	objHomePage = new VCFHomePage(driver);
//	//Verify home page
//	System.out.println(objHomePage.getCurrentURL());
//	
//	objHomePage.gotoIA();
//	System.out.println(objHomePage.getCurrentURL());
//	
//	objHomePage.gotoHome();
//	System.out.println(objHomePage.getCurrentURL());
//	
//	objHomePage.gotoPA();
//	System.out.println(objHomePage.getCurrentURL());
//	}
//
//}
