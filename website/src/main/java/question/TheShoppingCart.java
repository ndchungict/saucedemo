package question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.ProductsScreen;

public class TheShoppingCart implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return ProductsScreen.SHOPPING_CART.resolveFor(actor).isDisplayed();
    }
    public static Question<Boolean> displayed(){
        return new TheShoppingCart();
    }
}
