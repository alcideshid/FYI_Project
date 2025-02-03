package com.web.task;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.model.util.EnvironmentVariables;

public class GoTo implements Task {

    @Step("{0} open the URL")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url("https://fyi.ai/index.html"));
    }

    public static GoTo URL() {
        return Instrumented.instanceOf(GoTo.class).withProperties();
    }
}
