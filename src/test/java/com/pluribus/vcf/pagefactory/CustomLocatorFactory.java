package com.pluribus.vcf.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import java.lang.reflect.Field;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class CustomLocatorFactory implements ElementLocatorFactory {
	
	 private final WebDriver driver;

	    /**
	     *
	     * @param driver
	     */
	    public CustomLocatorFactory(WebDriver driver) {
	        this.driver = driver;
	    }

		public ElementLocator createLocator(Field field) {
			// TODO Auto-generated method stub
			 return new CustomElementLocator(driver, field);
		}

	
	    
	}


