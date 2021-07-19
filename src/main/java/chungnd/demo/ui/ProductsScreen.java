package chungnd.demo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsScreen {
    private ProductsScreen(){
        throw new  IllegalStateException("UI class");
    }

    public static final Target SHOPPING_CART = Target.the("Shopping Cart")
            .locatedForAndroid(By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView"))
            .locatedForIOS(By.xpath(""));
}
