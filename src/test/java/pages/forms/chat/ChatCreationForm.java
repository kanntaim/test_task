package pages.forms.chat;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class ChatCreationForm extends BasePage {
    private final SelenideElement chatNameInput = $("#im_dialogs_creation_name");
    private final SelenideElement createChatButton = $("._im_confirm_creation");

    public ChatCreationForm() {
        super($(".im-create_chat"));
    }

    public void fillChatName(String chatName){
        chatNameInput.shouldBe(Condition.interactable).sendKeys(chatName);
    }
    public void clickCreateNewConversation(){
        createChatButton.shouldBe(Condition.visible).click();
    }
}
