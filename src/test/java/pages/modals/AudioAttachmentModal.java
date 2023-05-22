package pages.modals;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AudioAttachmentModal extends BasePage {
    private static final String ATTACH_LOCATOR = ".ape_attach";
    private final ElementsCollection audioList = $$(".ape_audio_item_wrap");

    public AudioAttachmentModal() {
        super($(".audio_pl_edit_box"));
    }

    public void attachFirstAudio(){
        audioList.shouldHave(CollectionCondition.sizeGreaterThan(0)).first()
                .$(ATTACH_LOCATOR).shouldBe(Condition.visible).click();
    }
}
