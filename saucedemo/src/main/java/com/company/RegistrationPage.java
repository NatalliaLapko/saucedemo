package com.company;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;



public class RegistrationPage extends Locators {


    public void registration() {
        FIRSTNAME_FORM.sendKeys("Test");
        LASTNAME_FORM.sendKeys("USER");
        ZIP_CODE.sendKeys("123456");
        CONTINUE_BUTTON.click();

    }

    public void finish() {
        FINISH_BUTTON.click();
    }

    public void cancel() {
        CANCEL_BUTTON.click();
    }

    public double getTotalItem(){
        String totalItem = ITEM_TOTAL.getText().substring(ITEM_TOTAL.getText().lastIndexOf("$") + 1);
        double totalItemSum = Double.parseDouble(totalItem);
        return totalItemSum;

    }

    public double getTax(){
        String tax = TAX.getText().substring(TAX.getText().lastIndexOf("$") + 1);
        double taxSum = Double.parseDouble(tax);
        return taxSum;
    }

    public double getTotalSum() {
        String total = TOTAL.getText().substring(TOTAL.getText().lastIndexOf("$") + 1);
        double totalSum = Double.parseDouble(total);
        return totalSum;
    }


    public double totalSumCalculation() {
        double expectedTotalSum = getTotalItem() + getTax();
        return expectedTotalSum;
    }



    public double allItemsSum() {
        ElementsCollection cartItemsCollection = CartPage.CART_LIST.$$(By.cssSelector("div.cart_item_label"));
        int colSize = cartItemsCollection.size();
        System.out.println(colSize);
        double totalSum = 0;
        double itemPrice = 0;
        for (int i = 0; i < colSize; i++) {
            String temp = cartItemsCollection.get(i).$(By.cssSelector("div.inventory_item_price")).getText();
            temp = temp.substring(1);
            itemPrice = Double.parseDouble(temp);

        }

        return totalSum;


    }


    }






