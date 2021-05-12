import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

class SearchResultsPage {
    public ElementsCollection getResults() {
        return $$(By.id("search-result")).get(0).findAll(By.className("serp-item"));
    }
    public SelenideElement getResult(int index) {
        return $(By.className("serp-item"), index);
    }
}
