package com.hepsiburada.pages;

import com.hepsiburada.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public ProductPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@class='button big with-icon']")
    public WebElement firstSellerAddtoCartButton;

    @FindBy(xpath = "(//div[@class='marketplace-list']/table/tbody//td[3]/div[@class='addToCart'])[1]")
    public WebElement secondSellerAddtoCartButton;

    @FindBy(xpath = "//checkoutui-Modal-2iZXl")
    public WebElement closeAddedItemInfoButton;

    @FindBy(xpath = "//*[text()='Alışverişe devam et']")
    public WebElement continueShoppingButton;

    //@FindAll(
        //    {
                    @FindBy(xpath = "//*[@class='checkoutui-Modal-2iZXl']")
                    public WebElement closeAddedItemButton;
                   // @FindBy(xpath = "//*[text()='Alışverişe devam et']")
      //      }
    //)


    @FindBy(xpath = "//i[@class='close']")
    public WebElement closePopupButton;






}
