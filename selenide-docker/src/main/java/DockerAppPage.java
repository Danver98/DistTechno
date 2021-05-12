import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DockerAppPage {
    public void addItem(String text) {
        $(By.className("form-control")).val(text);
        $(By.className("btn-success")).click();
    }

    public void deleteItem(String text) {
        $$(By.className("container-fluid")).findBy(Condition.text(text));
        $(By.className("btn-success")).click();
    }
}
