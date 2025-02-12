package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.junit.Assert;
import starter.navigation.NavigateTo;
import starter.search.EnterUserCredentials;
import starter.search.LoginForm;

public class SearchStepDefinitions {

    @Given("{actor} opens sauce demo login page")
    public void researchingThings(Actor actor) {
        actor.wasAbleTo(NavigateTo.theSearchHomePage());
    }

    @When("{actor} login with credentials {string} {string}")
    public void searchesFor(Actor actor, String user, String pass) {
        actor.attemptsTo(
                EnterUserCredentials.userName(user).then(EnterUserCredentials.userPass(pass)).then(Click.on(LoginForm.LOGIN_BUTTON))
        );
    }

    @Then("{actor} should see sauce demo home page")
    public void should_see_information_about(Actor actor) {
        Assert.assertTrue(BrowseTheWeb.as(actor).getDriver().getCurrentUrl().contains("inventory"));
        System.out.println("-------------- SUCCESS --------------");
    }
}
