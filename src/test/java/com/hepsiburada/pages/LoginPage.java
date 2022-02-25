package com.hepsiburada.pages;

import com.hepsiburada.utilities.ConfigurationReader;
import com.hepsiburada.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//*[@name='username'])[1]")
    public WebElement emailInput;

    @FindBy(xpath = "(//*[@id='txtPassword'])[1]")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[@id='btnLogin']")
    public WebElement loginEmailButton;

    @FindBy(xpath = "//*[@id='btnEmailSelect']")
    public WebElement loginPasswordButton;


}
