package com.web.interactions;

import jxl.common.Assert;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import net.serenitybdd.annotations.Step;

public class ChangeTab implements Interaction {

    @Step("{0} performs a 'Tab switch'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        int numTabs = tabs.size();
        if (numTabs == 2) {
            driver.switchTo().window(tabs.get(1));
            driver.manage().window();
        } else {
            Assert.verify(false, "The new tab didn't open");
        }
    }

    public static ChangeTab newTab() {
        return Instrumented.instanceOf(ChangeTab.class).withProperties();
    }

}
