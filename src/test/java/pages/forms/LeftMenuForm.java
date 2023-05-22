package pages.forms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import lombok.Getter;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class LeftMenuForm extends BasePage {
    public enum Item {
        PROFILE("#l_pr"),
        NEWS("#l_nwsf"),
        MESSENGER("#l_msg"),
        CALLS("#l_ca"),
        FRIENDS("#l_fr"),
        GROUPS("#l_gr"),
        PHOTOS("#l_ph"),
        MUSIC("#l_aud"),
        VIDEOS("#l_vid"),
        CLIPS("#l_svd"),
        GAMES("#l_ap"),
        STICKERS("#l_stickers"),
        MARKET("#l_mk");

        @Getter
        private final String locator;
        Item(String locator) {
            this.locator = locator;
        }
    }

    public LeftMenuForm() {
        super($("#side_bar"));
    }

    public void clickMenuItem(Item item){
        Selenide.$(item.getLocator()).shouldBe(Condition.visible).click();
    }
}
