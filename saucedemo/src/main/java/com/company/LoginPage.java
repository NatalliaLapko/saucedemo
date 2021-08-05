package com.company;

import static com.codeborne.selenide.Selenide.*;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPage extends Locators {


   public void login() throws IOException{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/user.properties"));
        USERNAME_FIELD.sendKeys("standard_user");
        PASSWORD_FIELD.sendKeys("secret_sauce");
        LOGIN_BUTTON.click();

    }

    public void openLoginPage(){
        open("https://www.saucedemo.com/");
    }


}
