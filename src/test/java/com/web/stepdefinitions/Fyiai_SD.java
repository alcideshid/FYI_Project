package com.web.stepdefinitions;

import com.web.task.*;
import com.web.utils.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.web.userinterface.Fyiai.*;
import static com.web.utils.Constants.PHRASE;
import static com.web.utils.Constants.VALUES;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Fyiai_SD {

    @Before
    public void startBrowser() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void closeBrowser() {
        BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).getDriver().close();
    }

    @Given("^open the URL$")
    public void clientOpenTheURL() {
        theActorCalled(Constants.ACTOR).wasAbleTo(GoTo.URL());
        theActorInTheSpotlight().attemptsTo(WaitUntil.the(LOGO, isVisible()).forNoMoreThan(15).seconds());
    }

    @Then("search the phrase at the bottom of the page and realize the validation")
    public void searchThePhraseAtTheBottomOfThePageAndRealizeTheValidation() {
        theActorInTheSpotlight().attemptsTo(
                Scroll.to(BOTTOM_MENU).andAlignToTop(),
                Ensure.that(BOTTOM_PHRASE.resolveFor(theActorInTheSpotlight()).getText().toString()).isEqualTo(PHRASE));
    }

    @Then("Open the Hamburger Menu and validate that all the options are displayed")
    public void openTheHamburgerMenuAndValidateThatAllTheOptionsAreDisplayed() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(HAMBURGUER_MENU),
                WaitUntil.the(HAMBURGUER_MENU_CONTAINER, isVisible()).forNoMoreThan(2).seconds(),
                Ensure.that(HAMBURGUER_MENU_OPT_LIST.resolveAllFor(theActorInTheSpotlight()).textContents().toString()).isEqualTo(VALUES));
    }

    @Then("go to the option Contact Support and validate that the title Submit a request is displayed")
    public void goToTheOptionContactSupportAndValidateThatTheTitleSubmitARequestIsDisplayed() {
        theActorInTheSpotlight().attemptsTo(
                GoToSubmitARequestPage.goTo());

    }

    @Then("go to the page Submit a request perform the search {string} and validate that {int} records are displayed")
    public void goToThePageSubmitARequestPerformTheSearchAndValidateThatRecordsAreDisplayed(String text, Integer result) {
        theActorInTheSpotlight().attemptsTo(
                GoToSubmitARequestPage.goTo(),
                DoQuery.forText(text),
                ValidateResultsQuery.forNumber(result));
    }

}