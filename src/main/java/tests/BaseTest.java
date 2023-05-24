package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertiesUtil;

public class BaseTest {

    @BeforeMethod
    public void before(){
        Configuration.timeout = PropertiesUtil.getIntProperty("timeout");
        Selenide.open(PropertiesUtil.getProperty("url"));
    }

    @AfterMethod
    public void after(){
        Selenide.closeWebDriver();
    }
}
