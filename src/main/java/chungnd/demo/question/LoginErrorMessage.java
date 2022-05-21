package chungnd.demo.question;

import chungnd.demo.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginErrorMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginPage.ERROR_MESSAGE_CONTAINER).answeredBy(actor);
    }

    public static Question<String> content() {
        return new LoginErrorMessage();
    }
}
