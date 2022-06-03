package com.cydeo.pages;

import com.cydeo.utils.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {
    public CalculatorPage() {

        //we're adding everything the same as in standard POM but with mobile testing
        //specific: 'new AppiumFieldDecorator' attached to Driver.getDriver;
        //@AndroidFindBy instead of FindBy;
        //MobileElement instead of WebElement
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(accessibility = "multiply")
    public MobileElement multiply;

    @AndroidFindBy(accessibility = "equals")
    public MobileElement equals;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    public MobileElement result;

    public void multiply() {
        multiply.click();
    }

    public void clickSingleDigit(int digit) {
        String id = "com.google.android.calculator:id/digit_" + digit;
        MobileElement number = Driver.getDriver().findElement(By.id(id));
        number.click();
    }
}
