package pages.forms.chat;

import com.codeborne.selenide.*;
import enums.CssConstants;
import lombok.Getter;
import pages.BasePage;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ConversationForm extends BasePage {
    private static final String AUDIO_LOCATOR = ".post_media_audio";
    private static final String PHOTO_LOCATOR = ".page_post_sized_thumbs";

    public enum MediaSelectorItem {
        PHOTO(".ms_item_photo"),
        VIDEO(".ms_item_video"),
        AUDIO(".ms_item_audio"),
        DOCUMENT(".ms_item_doc"),
        MAP(".ms_item_map"),
        APP_DIRECT(".ms_item_app_action_mini_apps_ab_direct"),
        APP_CHAT(".ms_item_app_action_mini_apps_ab_chat"),
        APP_GIFT(".ms_item_gift"),
        POLL(".ms_item_poll"),
        MONEY(".ms_item_money");

        @Getter
        private final String locator;

        MediaSelectorItem(String locator) {
            this.locator = locator;
        }
    }

    private final SelenideElement mediaSelector = $("._im_media_selector");
    private final SelenideElement sendButton = $("._im_send");
    private final ElementsCollection messages = $$("._im_mess");
    private final SelenideElement photoAttachUnsent = $(".im-chat-input--attaches .thumb_wrap");
    private final SelenideElement chatName = $(".im-page--title-main-inner");

    public ConversationForm() {
        super($("._im_page_history"));
    }

    public void selectMediaSelector(MediaSelectorItem item) {
        mediaSelector.shouldBe(Condition.visible).hover();
        Selenide.$(item.getLocator()).shouldBe(Condition.visible).click();
    }

    public void clickSendButton(){
        sendButton.shouldBe(Condition.visible).click();
    }

    public Long getLastMessageDataTsOrZero(){
        return Optional.ofNullable(getLastMessage())
                        .map(msg -> msg.getAttribute(CssConstants.DATA_TS.getValue()))
                        .map(Long::parseLong)
                        .orElse(0L);
    }

    public boolean isAudioPresentInLastMessage(){
        return getLastMessage() != null && !getLastMessage().$$(AUDIO_LOCATOR).isEmpty();
    }

    public boolean isPhotoPresentInLastMessage(){
        return getLastMessage() != null && !getLastMessage().$$(PHOTO_LOCATOR).isEmpty();
    }

    public void waitForPhotoToLoad(){
        photoAttachUnsent.should(Condition.exist);
    }

    public String getChatName() {
        return chatName.shouldBe(Condition.visible).getText();
    }

    private SelenideElement getLastMessage() {
        waitForPageToLoad();
        if(messages.isEmpty()){
            return null;
        }
        return messages.shouldHave(CollectionCondition.sizeGreaterThan(0))
                .last().scrollIntoView(false);
    }
}
