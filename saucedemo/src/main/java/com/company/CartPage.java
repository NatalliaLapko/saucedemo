package com.company;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;



public class CartPage extends Locators {

    public void goToCart(){
        CART_BUTTON.click();
    }


    public static void addToCart() {

        ElementsCollection itemsCollection = CartPage.ITEMS_LIST.$$(By.cssSelector("div.inventory_item_description"));
        int itemsCollectionSize = itemsCollection.size();

        for (int i = 0;i <itemsCollectionSize; i++) {
            itemsCollection.get(i).$((By.xpath(".//button[text()='Add to cart']"))).click();
        }
    }


    public void addItems(int itemsQuantity){
        Selenide.sleep(2000);
        CartPage.ITEMS_LIST.shouldBe(Condition.visible);
        ElementsCollection itemsCollection = CartPage.ITEMS_LIST.$$(By.cssSelector("div.inventory_item_description"));
        int itemsCollectionSize = itemsCollection.size();

        for (int i = 0; i < itemsQuantity && itemsQuantity < itemsCollectionSize; i++) {
            itemsCollection.get(i).$((By.xpath(".//button[text()='Add to cart']"))).click();
        }
    }
    public void purchase () {
        CHECKOUT_BUTTON.click();
    }

    public int cartItemsNumber(){
        String itemsNumb = CartPage.CART_ITEMS_NUMBER.getText();
        int itemsNumber = Integer.getInteger(itemsNumb);
       return itemsNumber;
    }
}