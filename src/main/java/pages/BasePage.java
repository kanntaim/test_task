package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class BasePage {
    protected SelenideElement uniqueElement;

    protected BasePage(SelenideElement uniqueElement){
        this.uniqueElement = uniqueElement;
    }

    public boolean isPageLoaded(){
        return uniqueElement.isDisplayed();
    }

    public void waitForPageToLoad(){
        uniqueElement.should(Condition.exist);
    }
}
