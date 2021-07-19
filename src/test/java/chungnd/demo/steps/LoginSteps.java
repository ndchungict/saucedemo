package chungnd.demo.steps;

import chungnd.demo.ability.Authenticate;
import chungnd.demo.question.LoginErrorMessage;
import chungnd.demo.task.LoginToApplication;
import chungnd.demo.task.LoginToWebsite;
import chungnd.demo.ui.LoginScreen;
import chungnd.demo.ui.ProductPage;
import chungnd.demo.ui.ProductsScreen;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginSteps {
    /**
     * Login to website
     */
    @Given("^that (.*) is on the sauce demo website$")
    public void verify_user_is_on_sauce_demo_website(String actorName) throws Throwable {
        OnStage.theActorCalled(actorName).attemptsTo(
                Open.url("https://www.saucedemo.com/")
        );

    }

    @When("^(?:he|she|they) login with (?:valid|invalid) user$")
    public void user_login_with_credentials(DataTable credentials) throws Throwable {
        theActorInTheSpotlight().whoCan(Authenticate.with(credentials))
                .attemptsTo(LoginToWebsite.withCredentials());
    }

    @Given("^(?:he|she|they) should see the shopping cart$")
    public void user_should_see_the_shopping_cart() throws Throwable {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(ProductPage.SHOPPING_CART).isDisplayed()
        );
    }

  @Then("^(?:he|she|they) should see the error message \"([^\"]*)\"$")
    public void he_should_see_the_error_message(String message) throws Throwable {
        theActorInTheSpotlight().should(seeThat(
                LoginErrorMessage.content(),equalTo(message)
        ));
    }

    /**
     *
     * Login to application
     */

    @Given("^that (.*) is on the sauce demo application$")
    public void verify_user_is_on_sauce_demo_application(String actorName) throws Throwable {
        OnStage.theActorCalled(actorName).attemptsTo(
                Ensure.that(LoginScreen.LOGIN_BUTTON).isDisplayed()
        );

    }

    @When("^(?:he|she|they) login to application with (?:valid|invalid) user$")
    public void user_login_to_application_with_credentials(DataTable credentials) throws Throwable {
        theActorInTheSpotlight().whoCan(Authenticate.with(credentials))
                .attemptsTo(LoginToApplication.withCredentials());
    }

    @Given("^On the application (?:he|she|they) should see the shopping cart$")
    public void on_the_application_user_should_see_the_shopping_cart() throws Throwable {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(ProductsScreen.SHOPPING_CART).isDisplayed()
        );
    }
}
