package pages.forms;

import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class HeaderForm extends BasePage {

    public HeaderForm() {
        super($("#top_profile_link"));
    }
}
