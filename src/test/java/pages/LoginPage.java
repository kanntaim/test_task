package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private final SelenideElement mailPhoneInput = $("#index_email");
    private final SelenideElement signInButton = $(".VkIdForm__signInButton");

    public LoginPage() {
        super($("#index_login"));
    }

    public void fillMailOrPhone(String mailOrPhoneText){
        mailPhoneInput.shouldBe(Condition.editable).sendKeys(mailOrPhoneText);
    }

    public void clickSignInButton(){
        signInButton.shouldBe(Condition.interactable).click();
    }
}
