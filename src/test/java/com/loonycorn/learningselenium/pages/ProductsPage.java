package com.loonycorn.learningselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    private WebDriver driver;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartButton;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

    public void navigateToProductPage(String productXpath) {
        WebElement productLink = driver.findElement(By.xpath(productXpath));
        productLink.click();
    }

    public void navigateToCart() {
        cartButton.click();
    }
}