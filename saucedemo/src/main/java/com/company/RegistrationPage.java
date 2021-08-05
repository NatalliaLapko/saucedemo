package com.company;


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


    }






