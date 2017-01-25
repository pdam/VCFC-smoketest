package com.pluribus.vcf.pagefactory;


import java.lang.reflect.Field;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.openqa.selenium.By;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.pagefactory.Annotations;

/**
 *
 * @author chandra
 */
public class CustomAnnotations extends Annotations {

    private Field field;
     private static String WILDCHAR = "%";
     private static String WILDCHAR_REGEX = "%(.*?)\\%";

    public CustomAnnotations(Field field) {
        super(field);
    }

    /**
     * Method to build from long form of FindBy.
     *
     * @param findBy FindBy
     * @return By
     */
    @Override
    protected By buildByFromLongFindBy(FindBy findBy) {
        How how = findBy.how();
        String using = findBy.using();
        switch (how) {
            case CLASS_NAME:
                return By.className(using);
            case CSS:
                return By.cssSelector(using);
            case ID:
                return By.id(using);
            case ID_OR_NAME:
                return new ByIdOrName(using);
            case LINK_TEXT:
                return By.linkText(PropertiesUtil.getMessage(using));
            case NAME:
                return By.name(using);
            case PARTIAL_LINK_TEXT:
                return By.partialLinkText(using);
            case TAG_NAME:
                return By.tagName(using);
            case XPATH:
                String v = StringUtils.substringBetween(using, "%", "%");
                if (v != null) {
                  using = using.replaceAll("%(.*?)\\%", PropertiesUtil.getMessage(v));
                }
                return By.xpath(using);
        }
        throw new IllegalArgumentException("Cannot determine how to locate element " + this.field);
    }

    /**
     * Method to resolve property specified as key.
     *
     * @param using String
     * @return String
     */
    @Override
    protected By buildByFromShortFindBy(FindBy findBy) {
        if (!"".equals(findBy.linkText())) {
            try {
                return By.linkText(ResourceBundle.getBundle("com.pluribus.Messages").getString(findBy.linkText()));
            } catch (MissingResourceException ex) {
                return By.linkText(findBy.linkText());
            }
        }
        return super.buildByFromShortFindBy(findBy);
    }
}
