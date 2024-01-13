import org.junit.jupiter.api.Test;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderingServiceTest {
    @Test
    void shouldTestData() throws InterruptedException {
        open("http://localhost:9999/");
        SelenideElement form = $("[autocomplete=on]");
        form.$("[data-test-id=name] input").setValue("Прохорова Анна-Мария");
        form.$("[data-test-id=phone] input").setValue("+79162354864");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

}