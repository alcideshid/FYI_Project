package com.web.task;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.web.userinterface.Fyiai.QUERY_FIELD;
import static com.web.userinterface.Fyiai.TITLE_RESULTS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DoQuery implements Task {
    private String text;

    public DoQuery(String text) {
        this.text = text;
    }

    @Step("{0} do the query")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                SendKeys.of(text).into(QUERY_FIELD),
                SendKeys.of(Keys.ENTER).into(QUERY_FIELD),
                WaitUntil.the(TITLE_RESULTS, isVisible()).forNoMoreThan(2).seconds());
    }

    public static DoQuery forText(String text) {
        return Instrumented.instanceOf(DoQuery.class).withProperties(text);
    }

}
