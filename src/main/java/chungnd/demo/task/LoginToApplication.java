package chungnd.demo.task;


import chungnd.demo.ability.Authenticate;
import chungnd.demo.ui.LoginScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginToApplication implements Task {
    private Authenticate authenticated(Actor actor) {
        return Authenticate.as(actor);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(authenticated(actor).getUsername()).into(LoginScreen.USERNAME_FIELD),
                Enter.theValue(authenticated(actor).getPassword()).into(LoginScreen.PASSWORD_FIELD),
                Click.on(LoginScreen.LOGIN_BUTTON)
        );
    }

    public static LoginToApplication withCredentials() {
        return Tasks.instrumented(LoginToApplication.class);
    }
}
