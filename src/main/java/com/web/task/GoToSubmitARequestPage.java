package com.web.task;

import com.web.interactions.ChangeTab;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.web.userinterface.Fyiai.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class GoToSubmitARequestPage implements Task {

    @Step("{0} go to 'Submit a request' page")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(HAMBURGUER_MENU),
                WaitUntil.the(HAMBURGUER_MENU_CONTAINER, isVisible()).forNoMoreThan(2).seconds(),
                Click.on(MENU_HELP),
                ChangeTab.newTab(),
                WaitUntil.the(TITLE_PAGE_HELP, isVisible()).forNoMoreThan(2).seconds(),
                Click.on(BUTTON_CONTACT_SUPPORT),
                WaitUntil.the(TITLE_SUBMIT_A_REQUEST, isVisible()).forNoMoreThan(2).seconds(),
                Ensure.that(TITLE_SUBMIT_A_REQUEST).isDisplayed());
    }

    public static GoToSubmitARequestPage goTo() {
        return Instrumented.instanceOf(GoToSubmitARequestPage.class).withProperties();
    }

}
