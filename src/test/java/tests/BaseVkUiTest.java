package tests;

import org.testng.annotations.BeforeMethod;
import steps.AuthSteps;

public class BaseVkUiTest extends BaseTest{
    @BeforeMethod
    public void beforeMethod(){
        new AuthSteps().login();
    }
}
