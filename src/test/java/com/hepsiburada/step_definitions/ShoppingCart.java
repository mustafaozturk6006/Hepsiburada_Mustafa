package com.hepsiburada.step_definitions;

import com.hepsiburada.pages.*;
import com.hepsiburada.utilities.BrowserUtils;
import com.hepsiburada.utilities.ConfigurationReader;
import com.hepsiburada.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class ShoppingCart {

    Dashboard dashboard = new Dashboard();
    LoginPage loginPage = new LoginPage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    BrowserUtils browserUtils = new BrowserUtils();

    String seller1="";
    String seller2="";
    String product="";

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() throws InterruptedException {

        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("click -Giriş Yap- option from -Giriş Yap- dropdown")
    public void clickGirişYapOptionFromGirişYapDropdown(){

        dashboard.onGirisYap.click();
        browserUtils.waitFor(1);
        dashboard.girisYap.click();
        browserUtils.waitFor(1);

    }

    @And("enter email and click -Giriş Yap- button")
    public void enterEmailAndClickGirişYapButton() {

        loginPage.emailInput.sendKeys(ConfigurationReader.get("username"));
        loginPage.loginEmailButton.click();

    }

    @And("enter password and click -Giriş Yap- button")
    public void enterPasswordAndClickGirişYapButton() {

        loginPage.passwordInput.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginPasswordButton.click();
    }

    @Then("verify that user logged in successfully")
    public void verifyThatUserLoggedInSuccessfully(){

        dashboard.Hesabim.click();
        dashboard.kullaniciBilgileri.click();
        browserUtils.waitFor(2);

        String expectedEmail = ConfigurationReader.get("username");
        String actualEmail = Driver.get().findElement(By.xpath("//*[contains(text(),'"+ConfigurationReader.get("username")+"')]")).getText();

        Assert.assertEquals("No login or wrong email",expectedEmail,actualEmail);

        Driver.get().navigate().back();

    }

    @And("enter the item {string} into search box and click -Ara- button")
    public void enterTheItemIntoSearchBoxAndClickAraButton(String item){

        browserUtils.waitFor(2);
        dashboard.searchBox.sendKeys(item);
        browserUtils.waitFor(2);
        dashboard.searchButton.click();
        browserUtils.waitFor(2);

    }

    @And("click the item")
    public void clickTheItem(){

        product = Driver.get().findElement(By.xpath("//*[@id='i0']//h3")).getText();
        searchPage.firstItem.click();

    }

    @And("click -Sepete Ekle- from the first Seller")
    public void clickSepeteEkleFromTheFirstSeller(){

        String currentWindowHandle = Driver.get().getWindowHandle();

        Set<String> windowHandles = Driver.get().getWindowHandles();

        for (String handle : windowHandles) {

            if(!handle.equals(currentWindowHandle)){
                Driver.get().switchTo().window(handle);
            }
        }
        browserUtils.waitFor(2);
        seller1 = Driver.get().findElement(By.xpath("//span[@class='seller']/span[2]/a")).getText();
        productPage.firstSellerAddtoCartButton.click();
        browserUtils.waitForClickablility(productPage.closeAddedItemButton,6);
        productPage.closeAddedItemButton.click();
        browserUtils.waitFor(2);

    }

    @And("click -Sepet Ekte- from -Diğer Satıcılar- Section")
    public void clickSepetEkteFromDiğerSatıcılarSection(){

        browserUtils.waitFor(2);
        seller2 = Driver.get().findElement(By.xpath("//div[@class='marketplace-list']/table/tbody/tr[1]/td[1]/div[1]/a[1]")).getText();
        browserUtils.waitForClickablility(productPage.secondSellerAddtoCartButton,6);
        productPage.secondSellerAddtoCartButton.click();
        browserUtils.waitForClickablility(productPage.closePopupButton,6);
        productPage.closePopupButton.click();
        browserUtils.waitForClickablility(productPage.closeAddedItemButton,6);
        productPage.closeAddedItemButton.click();

    }

    @Then("Verify that item added into the shopping cart successfully")
    public void verifyThatItemAddedIntoTheShoppingCartSuccessfully(){
        int actualSellerCount =0;
        int expectedSellerCount = 2;
        int actualProductCount=0;
        int expectedProductCount=2;

        cartPage.shoppingCartButton.click();
        browserUtils.waitFor(2);

        for (WebElement sellerName: cartPage.sellerNames) {
            if((sellerName.getText().equalsIgnoreCase(seller1)) || (sellerName.getText().equalsIgnoreCase(seller2))){
                actualSellerCount++;
            }
        }

        for (WebElement productName: cartPage.productNames) {
            if(productName.getText().equalsIgnoreCase(product)){
                actualProductCount++;
            }
        }


        Assert.assertTrue((actualSellerCount==expectedSellerCount)&&(actualProductCount==expectedProductCount));

        browserUtils.waitFor(2);
        cartPage.deleteAllButton.click();
        cartPage.deleteConfirmButton.click();
        browserUtils.waitFor(2);

    }
}
