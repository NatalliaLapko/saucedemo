package com.company;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class Locators {
    //Login page
    public static SelenideElement USERNAME_FIELD = $(By.id("user-name"));
    public static SelenideElement PASSWORD_FIELD = $(By.id("password"));
    public static SelenideElement LOGIN_BUTTON = $(By.id("login-button"));


   //Main Page

    public static SelenideElement CART_BUTTON = $("a.shopping_cart_link");
    public static SelenideElement ITEMS_LIST = $("div#inventory_container");

    //Cart Page
    public static SelenideElement CHECKOUT_BUTTON = $(By.id("checkout"));


    public static SelenideElement CONTINUE_BUTTON = $(By.id("continue"));
    public static SelenideElement CONTINUE_SHOPPING = $(By.id("continue-shopping"));

    public static SelenideElement CART_LIST = $("div#cart_contents_container");
    public static SelenideElement FINAL_LIST = $("div#checkout_summary_container");
    public static SelenideElement CART_ITEMS_NUMBER = $("span.shopping_cart_badge");

public static SelenideElement ITEM_DESCRIPTION = $("div.inventory_item_description");



    //Registration form
    public static SelenideElement FIRSTNAME_FORM = $("input#first-name");
    public static SelenideElement LASTNAME_FORM = $("input#last-name");
    public static SelenideElement ZIP_CODE = $("input#postal-code");


    public static SelenideElement FINISH_BUTTON = $(By.id("finish"));
    public static SelenideElement CANCEL_BUTTON = $("button#cancel");

    public static SelenideElement ITEM_TOTAL = $("div.summary_subtotal_label");
    public static SelenideElement TAX = $("div.summary_tax_label");
    public static SelenideElement TOTAL = $("div.summary_total_label");

    public static SelenideElement MENU_BUTTON = $("button#react-burger-menu-btn");
    public static SelenideElement ALL_ITEMS = $ ("a#inventory_sidebar_link");


    public static SelenideElement BACK_HOME = $("button#back-to-products");
    public static SelenideElement FINAL_NOTICE =$("h2.complete-header");

}