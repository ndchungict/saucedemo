package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    private LoginPage() {
        throw new IllegalStateException("UI class");
    }

    public static final Target USERNAME_FIELD = Target.the("Username text box")
            .located(By.id("user-name"));

    public static final Target PASSWORD_FIELD = Target.the("Password text box")
            .located(By.id("password"));

    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .located(By.id("login-button"));

    public static final Target ERROR_MESSAGE_CONTAINER = Target.the("Error message")
            .located(By.xpath("//div[@class='login-box']//h3"));
}
