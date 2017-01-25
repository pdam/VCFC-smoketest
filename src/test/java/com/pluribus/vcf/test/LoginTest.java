package com.pluribus.vcf.test;

import com.pluribus.vcf.test.TestInfra;

import junit.framework.Assert;

import com.pluribus.vcf.pagefactory.LicenseTypes;
import com.pluribus.vcf.pagefactory.VCFHomePage;
import com.pluribus.vcf.pagefactory.VCFLoginPage;
import com.pluribus.vcf.pagefactory.VcfSettingsPage;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Haritha
 */


public class LoginTest extends TestInfra {
    
//    @Page
    private VCFLoginPage login;
    private VCFHomePage home;
    private VcfSettingsPage settings;
    private String userName = "network-admin";
    private String password = "test123";
    private String vcfUserName  = "admin";
    private String mgmtip = "10.9.21.212";
    private String switchName = "leo-vcf-1";
    private String dataNodeName  = "Node1";
    private String dataNodeHost = "10.9.8.85";
    private String heapSize = "30";
    private String nodePassword = "changeme";
    private String nodeUserName= "vcf";
    private String pncPwd = "test123";
    private String pncuName= "pn-vcf";
    
   
    
    @BeforeClass
    public void init() {
       login = new VCFLoginPage(getDriver());
       home = new VCFHomePage(getDriver());
       settings = new VcfSettingsPage(getDriver());
    }
    
    @Test(dependsOnMethods = { "loginAsAdmin" },description = "Login to VCF as test123 After Password Change")
    public void loginAsTest123() {
        login.login(vcfUserName, password);
        login.waitForLogoutButton();
        assertEquals(getTitle(), "VCF Insight Analytics");
    }
    
    @Test(dependsOnMethods = { "vcfsettingsPagenavigations" },description = "Add Seed Switch & verify")
    public void addSeedSwitch() throws Exception{
    	settings.addSeedSwitch(switchName, userName, mgmtip, password);
    	String switchDetails = settings.verifySeedSwitch(switchName, userName, mgmtip, password);
    	if(switchDetails.isEmpty()){
    		throw new Exception(" Seed Switch Creation is failed");
    	}

    }
    
    @Test(dependsOnMethods = { "addSeedSwitch" },description = "Add data node & verify")
    public void addDataNode() throws Exception{
    	settings.addDataNode(dataNodeName, dataNodeHost, nodeUserName, heapSize, nodePassword);
    	String nodeDetails = settings.verifyDataNode(dataNodeName);
    	if(nodeDetails.isEmpty()){
    		throw new Exception(" Add Data Node failed ");
    	}
    }
    
    @Test(dependsOnMethods = { "loginAsTest123" },description = "Add data node & verify")
    public void activateLicense() throws Exception{
    	settings.activateLicense(pncuName, pncPwd, LicenseTypes.VCFC_SSC_1YR_10M);
    }
    
    @Test(dependsOnMethods = { "loginAsTest123" },description = "Navigate all pages in VCF settings page")
    public void vcfsettingsPagenavigations() {
    	settings.navigateToSwitchMenu();
    	settings.navigateToSystemhealthMenu();
    	settings.navigateToServerMenu();
    	settings.navigateTocertsMenu();
    	settings.navigateToadminMenu();
    	settings.navigateToAppMenu();
    }
    @Test(description = "Login to VCF as admin  and Change Password")
    public void loginAsAdmin() {
        login.firstlogin(vcfUserName, password);
    }
    
    @Test
    public void logout() {
        login.logout();
    }
    
    
}
