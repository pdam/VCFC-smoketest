package com.pluribus.vcf.pagefactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pluribus.vcf.pagefactory.*;

public class VCFHomePage extends BasicInfra{

	
	
	@FindBy(how = How.XPATH, using = "//*[@id='pie-vcf-ia']/div/div")
	WebElement vcfIAIcon;

	@FindBy(how = How.XPATH, using = "//*[@id='pie-vcf-pa']/div/div")
	WebElement vcfPAIcon;

	@FindBy(css = "a.fa.fa-sign-out")
	WebElement vcfLogout;

	@FindBy(how = How.XPATH, using = ".//a[contains(@href,'/vcf-center/#/main')]")
	WebElement vcfHomeIcon;
	
	@FindBy(how = How.XPATH, using = ".//a[contains(@href,'/vcf-center/#/config/switch')]")
	WebElement vcfSettingsIcon;
	

	

	public VCFHomePage(WebDriver driver) {
         super(driver);
	}


	public String gotoHome() {
        this.driver.getCurrentUrl();
		System.out.println(this.driver.getCurrentUrl());
		System.out.println("VCF Home ICON is displayed ? " + vcfHomeIcon.isDisplayed());
		vcfHomeIcon.click();
		System.out.println(this.driver.getCurrentUrl());
		return this.driver.getTitle();

	}

////	public String gotoIA() {
////		System.out.print("Entered in to IA dunction");
////		
////	//System.out.print("IA ICON is enabled ? " + driver.findElement(By.id("pie-vcf-ia")).isDisplayed());
////		while (!this.driver.findElement(By.id("pie-vcf-ia")).isDisplayed()) {
////			System.out.print("Entered while loop");
////			try {
////				Thread.sleep(10);
////			} catch (InterruptedException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
////		System.out.print("IA ICON is enabled ? " + driver.findElement(By.id("pie-vcf-ia")).isDisplayed());
////
////		vcfIAIcon.click();
////
////		System.out.print("Get Title : " + this.driver.getTitle());
////		System.out.print("Get URL : " + this.driver.getCurrentUrl());
////
////		return this.driver.getTitle();
////	}
////
////	public String gotoPA() {
////		
////		System.out.print("PA Pie is enabled ? " + driver.findElement(By.id("pie-vcf-pa")).isDisplayed());
////
////		while (!this.driver.findElement(By.id("pie-vcf-pa")).isDisplayed()) {
////			try {
////				Thread.sleep(10);
////			} catch (InterruptedException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
////		System.out.print("PA Pie is enabled ? " + this.driver.findElement(By.id("pie-vcf-pa")).isDisplayed());
////
////		vcfPAIcon.click();
////
////		System.out.print("Get Title : " + this.driver.getTitle());
////		System.out.print("Get URL : " + this.driver.getCurrentUrl());
////		return this.driver.getTitle();
////	}
//	
//	public String gotoPA() {
//		String iaURL;
//		try {
//			iaURL = "https://"+ new URL(getCurrentURL()).getHost()+ "/vcf-pa";
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return  null;
//		}
//		this.driver.get(iaURL);
//		
//		System.out.println(this.driver.getCurrentUrl());
//		return this.driver.getTitle();
//		
//		
//	}
//	public String gotoIA() {
//		String iaURL;
//		try {
//			iaURL = "https://"+ new URL(getCurrentURL()).getHost()+ "/vcf-ia";
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return  null;
//		}
//		this.driver.get(iaURL);
//		
//		System.out.println(this.driver.getCurrentUrl());
//		return this.driver.getTitle();
//		
//		
//	}
	
	public String gotoVCFSettings() {
    	this.driver.getCurrentUrl();
		System.out.println(this.driver.getCurrentUrl());
		System.out.println("VCF Settings ICON is displayed ? " + vcfHomeIcon.isDisplayed());
		vcfSettingsIcon.click();
		System.out.println(this.driver.getCurrentUrl());
		return this.driver.getTitle();

	}

}
