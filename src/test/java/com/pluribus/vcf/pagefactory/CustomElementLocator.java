package com.pluribus.vcf.pagefactory;

import java.lang.reflect.Field;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;


public class CustomElementLocator implements ElementLocator {

    private final SearchContext searchContext;
    private final boolean shouldCache;
    private final By by;
    private WebElement cachedElement;
    private List<WebElement> cachedElementList;

    /**
     * Creates a new element locator.
     *
     * @param searchContext The context to use when finding the element
     * @param field The field on the Page Object that will hold the located
     * value
     */
    public CustomElementLocator(SearchContext searchContext, Field field) {
        this.searchContext = searchContext;
        CustomAnnotations annotations = new CustomAnnotations(field);
        shouldCache = annotations.isLookupCached();
        by = annotations.buildBy();
    }

    /**
     * Find the element.
     */
    public WebElement findElement() {
        if (cachedElement != null && shouldCache) {
            return cachedElement;
        }

        WebElement element = searchContext.findElement(by);
        if (shouldCache) {
            cachedElement = element;
        }

        return element;
    }

    /**
     * Find the element list.
     */

    public List<WebElement> findElements() {
        if (cachedElementList != null && shouldCache) {
            return cachedElementList;
        }

        List<WebElement> elements = searchContext.findElements(by);
        if (shouldCache) {
            cachedElementList = elements;
        }

        return elements;
    }

}
