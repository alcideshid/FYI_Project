package com.web.task;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.web.userinterface.Fyiai.*;
import static com.web.utils.Constants.TEXT_RESULTS;

public class ValidateResultsQuery implements Task {
    private Integer number;

    public ValidateResultsQuery(Integer number) {
        this.number = number;
    }

    @Step("{0} validate the results of the query")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Ensure.that(TITLE_RESULTS.resolveFor(actor).getText().toString()).isEqualTo(number + TEXT_RESULTS)
        );

        int pag1 = RESULTS_QUERY.resolveAllFor(actor).size();

        actor.attemptsTo(
                Click.on(PAG_NEXT_BUTTON)
        );

        int pag2 = RESULTS_QUERY.resolveAllFor(actor).size();
        int result = pag1 + pag2;

        actor.attemptsTo(
                Ensure.that(result).isEqualTo(number)
        );

    }

    public static ValidateResultsQuery forNumber(Integer number) {
        return Instrumented.instanceOf(ValidateResultsQuery.class).withProperties(number);
    }

}
