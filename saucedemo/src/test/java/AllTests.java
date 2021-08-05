

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import com.company.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.io.IOException;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AllTests {

    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;

    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("LogIn")
    @Order(1)
    public void login() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        loginPage.login();

        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", url(), "Wrong page!");
    }

    @Test
    @DisplayName("Ordering")
    @Order(3)
    public void purchase() throws IOException {
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();
        RegistrationPage registrationPage = new RegistrationPage();
        loginPage.openLoginPage();
        loginPage.login();
        CartPage.addToCart();
        cartPage.goToCart();
        cartPage.purchase();
        registrationPage.registration();
        registrationPage.finish();
        FinalPage finalPage = new FinalPage();
        finalPage.currentURL();
        String notice = finalPage.getFinalNotice();
        Selenide.sleep(4000);


        Assertions.assertEquals("https://www.saucedemo.com/checkout-complete.html", url(), "Wrong page!");
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", notice, "Wrong message!");

    }

    @Test
    @DisplayName("Order cancellation")
    @Order(2)
    public void orderCancellation() throws IOException {
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();
        RegistrationPage registrationPage = new RegistrationPage();
        loginPage.openLoginPage();
        loginPage.login();
        cartPage.addToCart();
        cartPage.goToCart();
        cartPage.purchase();
        registrationPage.registration();
        registrationPage.cancel();
        Selenide.sleep(2000);

        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", url());

    }


    @Test
@DisplayName("Items Removing")
    @Order(4)
    public void removeItemsFromCart() throws IOException {
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();
        loginPage.openLoginPage();
        loginPage.login();
        cartPage.addToCart();
        cartPage.goToCart();
        Selenide.sleep(2000);
        CartPage.CART_LIST.shouldBe(Condition.visible);
        ElementsCollection cartItemsCollection = CartPage.CART_LIST.$$(By.cssSelector("div.cart_item"));
        int colSize = cartItemsCollection.size();

        for (int i = 0; i < colSize; i++) {
            cartItemsCollection.first().$((By.xpath(".//button[text()='Remove']"))).click();
        }

        colSize = cartItemsCollection.size();

       Assertions.assertTrue(colSize == 0);




    }



    @Test
    @DisplayName("Total Sum Calculation")
    @Order(5)
    public void totalItems() throws IOException {
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();
        RegistrationPage registrationPage = new RegistrationPage();
        loginPage.openLoginPage();
        loginPage.login();
        cartPage.addToCart();
        cartPage.goToCart();
        cartPage.purchase();
        registrationPage.registration();
        Selenide.sleep(2000);
        CartPage.FINAL_LIST.shouldBe(Condition.visible);
        ElementsCollection cartItemsCollection = CartPage.FINAL_LIST.$$(By.cssSelector("div.cart_item_label"));
        int colSize = cartItemsCollection.size();
        //System.out.println(colSize);
        double totalItem = 0;
        double itemPrice = 0;
        for (int i = 0; i < colSize; i++) {
            String temp = cartItemsCollection.get(i).$(By.cssSelector("div.inventory_item_price")).getText();
            temp = temp.substring(1);
            itemPrice = Double.parseDouble(temp);
            totalItem = totalItem + itemPrice;

        }

        double totalSum =  totalItem + registrationPage.getTax();
        Selenide.sleep(2000);

         System.out.println("Total Item = " + totalItem);
         System.out.println("Tax = " + registrationPage.getTax());
         System.out.println("Total Sum = " + totalSum);
         System.out.println("RealSum = " + registrationPage.getTotalSum() + "\n" + "ExpectedSum = " + totalSum);

        Assertions.assertTrue(totalItem == registrationPage.getTotalItem());
        Assertions.assertTrue(totalSum == registrationPage.getTotalSum());




    }
}















