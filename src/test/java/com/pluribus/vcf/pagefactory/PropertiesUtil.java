package com.pluribus.vcf.pagefactory;

import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class PropertiesUtil {

    private static ResourceBundle rb;

    public static String getMessage(String message) {
        try {
            rb = ResourceBundle.getBundle("com.pluribus.Messages");
            return rb.getString(message);
        } catch (MissingResourceException ex) {
            return message;
        }
    }
    
    public static boolean stringContains(String source, String pattern1) {       
       boolean result = false;
       if(source.contains(pattern1)){
           result= true;
       }
       return result;
    }   
}
