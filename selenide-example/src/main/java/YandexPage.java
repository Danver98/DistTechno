import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class YandexPage {
    public void searchFor(String text) {
        $(By.id("text")).val(text).pressEnter();
    }
}