package chungnd.demo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage {
    private ProductPage(){
        throw new  IllegalStateException("UI class");
    }

    public static final Target SHOPPING_CART = Target.the("Shopping Cart")
            .located(By.id("shopping_cart_container"));
}
