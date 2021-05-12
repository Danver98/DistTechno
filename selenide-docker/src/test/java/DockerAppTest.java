
import org.junit.Test;


import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class DockerAppTest {
    @Test
    public void userCanAdd() {
        open("http://localhost:3000/");
        String person = "Steve";
        new DockerAppPage().addItem(person);
        ItemPage results = new ItemPage();
        int size = results.getResults().size();
        results.getResult(size -1).shouldHave(text(person));
    }
    @Test
    public void userCanDelete(){
        open("http://localhost:3000/");
        String [] persons = new String[]{"Steve", "John", "Max"};
        DockerAppPage page = new DockerAppPage();
        Arrays.stream(persons).forEach(page::addItem);
        page.deleteItem(persons[0]);
        ItemPage results = new ItemPage();
        int size = results.getResults().size();
        results.getResults().shouldHaveSize(persons.length -1);
        results.getResults().
    }
}
