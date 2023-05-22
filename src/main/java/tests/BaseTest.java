package tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import utils.PropertiesUtil;

public class BaseTest {

    @BeforeMethod
    public void before(){
        Selenide.open(PropertiesUtil.getProperty("url"));
    }
}
