package com.loonycorn.learningselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalCheckoutPage {
    private WebDriver driver;

    @FindBy(css = ".summary_value_label[data-test='payment-info-value']")
    private WebElement paymentInfoValue;

    @FindBy(css = ".summary_value_label[data-test='shipping-info-value']")
    private WebElement shippingInfoValue;

    @FindBy(css = ".summary_total_label[data-test='total-label']")
    private WebElement totalLabel;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public FinalCheckoutPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened() {
        return driver.getCurrentUrl().contains("checkout-step-two.html");
    }

    public String getPaymentInfoValue() {
        return paymentInfoValue.getText();
    }

    public String getShippingInfoValue() {
        return shippingInfoValue.getText();
    }

    public String getTotalLabel() {
        return totalLabel.getText();
    }

    public void finishCheckout() {
        finishButton.click();
    }
}
