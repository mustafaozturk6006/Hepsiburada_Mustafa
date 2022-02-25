package com.hepsiburada.pages;

import com.hepsiburada.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    public CartPage(){
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath = "//span[@id='cartItemCount']")
    public WebElement shoppingCartButton;

    @FindBy(xpath = "//span[@class='merchantLink_2Ii8s']/a")
    public List<WebElement> sellerNames;

    @FindBy(xpath = "//div[@class='product_name_3Lh3t']/a")
    public List<WebElement> productNames;

    @FindBy(xpath = "//div[@class='delete_all_2uTds']")
    public WebElement deleteAllButton;

    @FindBy(xpath = "//button[@class='red_3m-Kl']")
    public WebElement deleteConfirmButton;



}
