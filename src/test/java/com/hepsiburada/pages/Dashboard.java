package com.hepsiburada.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends BasePage{

    @FindBy(xpath = "//*[@id='login']")
    public WebElement girisYap;

    @FindBy(xpath = "//*[@id='myAccount']/span/span[1]")
    public WebElement onGirisYap;

    @FindBy(xpath = "//*[@id='myAccount']/span/a/span[1]")
    public WebElement Hesabim;

    @FindBy(linkText = "Kullanıcı Bilgilerim")
    public WebElement kullaniciBilgileri;

    @FindBy(xpath = "//*[@id='SearchBoxOld']/div/div/div[1]/div[2]/input")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id='SearchBoxOld']/div/div/div[2]")
    public WebElement searchButton;

    @FindBy(xpath = "(//div[@class='sf-HeaderButton-rPL-k'])[2]")
    public WebElement myCart;


}
