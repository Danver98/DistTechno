import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class YandexTest {
    @Test
    public void userCanSearch() {
        open("https://yandex.ru/");
        String text = "ЯрГУ ИВТ";
        new YandexPage().searchFor(text);
        SearchResultsPage results = new SearchResultsPage();
        results.getResults().shouldHave(sizeGreaterThan(1));
        String liText = "ivt.uniyar.ac.ru";
        results.getResult(0).shouldHave(text(liText));
    }
}
