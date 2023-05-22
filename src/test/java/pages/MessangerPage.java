package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MessangerPage extends BasePage {
    private final SelenideElement newConversationButton = $("._im_create_convo");

    public MessangerPage() {
        super($(".im-page"));
    }

    public void clickCreateNewConversation(){
        newConversationButton.shouldBe(Condition.visible).click();
    }
}
