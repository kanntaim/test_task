package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage extends BasePage{
    private final SelenideElement passwordInput = $("[name='password']");
    private final SelenideElement continueButton = $("[type='submit']");

    public AuthPage() {
        super($("[name='password']"));
    }

    public void fillPassword(String password){
        passwordInput.shouldBe(Condition.editable).sendKeys(password);
    }

    public void clickContinueButton(){
        continueButton.shouldBe(Condition.interactable).click();
    }
}
