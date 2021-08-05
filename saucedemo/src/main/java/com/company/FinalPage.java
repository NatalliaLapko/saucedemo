package com.company;

import static com.codeborne.selenide.WebDriverRunner.url;

public class FinalPage extends Locators{

  //  public static void main(String[] args) {
public String getFinalNotice(){
    String finalNotice = FINAL_NOTICE.getText();
    return finalNotice;
}

public void currentURL(){
url();
    }
}

