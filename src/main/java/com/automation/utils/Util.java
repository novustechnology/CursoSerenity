package com.automation.utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class Util extends PageObject {


    public boolean scrollToElement(WebElementFacade element) {
        try {
            evaluateJavascript("arguments[0].scrollIntoView(true)",element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
