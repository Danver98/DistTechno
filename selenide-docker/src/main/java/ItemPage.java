import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
public class ItemPage {
    public ElementsCollection getResults() {
        return $$(By.className("container-fluid"));
    }
    public SelenideElement getResult(int index) {
        return $(By.className("container-fluid"), index);
    }
}
