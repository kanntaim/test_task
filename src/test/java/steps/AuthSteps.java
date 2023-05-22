package steps;

import io.qameta.allure.Step;
import pages.AuthPage;
import pages.LoginPage;
import pages.forms.HeaderForm;

public class AuthSteps {
    private final LoginPage loginPage = new LoginPage();
    private final AuthPage authPage = new AuthPage();
    private final HeaderForm headerForm = new HeaderForm();

    @Step("Залогиниться с параметрами по умолчанию")
    public void login(){
        synchronized (AuthSteps.class) {
            loginPage.fillMailOrPhone(System.getProperty("login"));
            loginPage.clickSignInButton();
            authPage.fillPassword(System.getProperty("password"));
            authPage.clickContinueButton();
            headerForm.waitForPageToLoad();
        }
    }
}
