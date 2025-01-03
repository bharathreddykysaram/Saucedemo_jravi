package com.loonycorn.learningselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartItemCount;

    @FindBy(css = ".btn_action")
    private WebElement continueButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened() {
        return driver.getCurrentUrl().contains("cart.html");
    }

    public String getCartItemCount() {
        return cartItemCount.getText();
    }

    public boolean productInCart(String productName) {
        WebElement product =  driver.findElement(By.xpath(
                String.format("//div[@class='inventory_item_name'][text()='%s']", productName)));

        return product != null;
    }


    public String getContinueButtonText() {
        return continueButton.getText();
    }

    public void continueCheckout() {
        continueButton.click();
    }
}

