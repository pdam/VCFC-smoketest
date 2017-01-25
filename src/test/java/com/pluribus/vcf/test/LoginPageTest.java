//package com.pluribus.vcf.test;
//
//
//
//import org.testng.annotations.Test;
//import org.testng.AssertJUnit;
//import java.io.IOException;
//import java.net.URL;
//import java.net.UnknownHostException;
//
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.BeforeTest;
//
//
//import com.jcabi.ssh.SSHByPassword;
//import com.jcabi.ssh.Shell;
//import com.pluribus.vcf.pagefactory.VCFHomePage;
//import com.pluribus.vcf.pagefactory.VCFLoginPage;
//
//
//
//
//public class LoginPageTest {
//
//	RemoteWebDriver driver;
//	VCFLoginPage objLogin;
//	VCFHomePage objHomePage;
//	
//	
//	@BeforeTest
//	  public void setUp() throws Exception {
//	    
//		
//		Runtime.getRuntime().exec("src/test/resources/BrowserStackLocal --key <key> --daemon  start");
//	    DesiredCapabilities capability = DesiredCapabilities.chrome();
//	    capability.setPlatform(Platform.WINDOWS);
//	    capability.setCapability("build", "JUnit - Sample");
//	    capability.setCapability("browserstack.local", "true");
//	    
//	     
//	    driver = new RemoteWebDriver(
//	      new URL("https://pratikdam1:uZCXEzKXwgzgzMr3G7R6@hub-cloud.browserstack.com/wd/hub"),
//	      capability
//	    );
//	    
//	  }
//	
//	@Test
//	public void test_CLIExecution(){
//	Shell shell = null;
//	try {
//		shell = new SSHByPassword("10.9.8.118", 22, "vcf", "changeme");
//	} catch (UnknownHostException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	String stdout = null;
//	try {
//		stdout = new Shell.Plain(shell).exec("date");
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	System.out.println(stdout);
//	}
//	/**
//	 * This test go to http://10.9.10.145
//	 * Verify login page title 
//	 * Login to application
//	 * Verify the home page using Dashboard url
//	 */
//	@Test
//	public void test_LoginLogout(){
//		//Create Login Page object
//	String url ="https://10.9.8.118";
//	objLogin = new VCFLoginPage(driver,url);
//	//Verify login page title
//	String loginPageTitle = objLogin.getLoginTitle();
//	AssertJUnit.assertEquals(loginPageTitle, "VCF Insight Analytics");
//	//login to application
//	objLogin.login("admin", "test123");
//	// go the next page
//	objHomePage = new VCFHomePage(driver);
//	System.out.println(objHomePage.getCurrentURL());
//	objHomePage.logout();
//	AssertJUnit.assertEquals(objHomePage.getCurrentURL() , url+"/vcf-center/auth/login#/main");
//	
//	}
//	/**
//	 * This test go to http://10.9.10.145
//	 * Verify login page title 
//	 * Login to application
//	 * Verify the home page using Dashboard url
//	 */
//	@SuppressWarnings("deprecation")
//	@Test
//	public void test_LoginAndBrowsePAandIAPages(){
//		//Create Login Page object
//	String url ="https://10.9.8.118";
//	objLogin = new VCFLoginPage(driver,url);
//	//Verify login page title
//	String loginPageTitle = objLogin.getLoginTitle();
//	AssertJUnit.assertEquals(loginPageTitle, "VCF Insight Analytics");
//	//login to application
//	objLogin.login("admin", "test123");
//	// go the next page
//	objHomePage = new VCFHomePage(driver);
//	//Verify home page
//	System.out.println(objHomePage.getCurrentURL());
//	objHomePage.gotoIA();
//	System.out.println(objHomePage.getCurrentURL());
//	
//	objHomePage.gotoPA();
//	System.out.println(objHomePage.getCurrentURL());
//	
//
//	
//	
//	}
//	
//}
