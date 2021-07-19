package chungnd.demo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginScreen {
    private LoginScreen() {
        throw new IllegalStateException("UI class");
    }

    public static final Target USERNAME_FIELD = Target.the("Username text box")
            .locatedForAndroid(By.xpath("//android.widget.EditText[@content-desc='test-Username']"))
            .locatedForIOS(By.xpath(""));

    public static final Target PASSWORD_FIELD = Target.the("Password text box")
            .locatedForAndroid(By.xpath("//android.widget.EditText[@content-desc='test-Password']"))
            .locatedForIOS(By.xpath(""));

    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .locatedForAndroid(By.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']"))
            .locatedForIOS(By.xpath(""));

}
