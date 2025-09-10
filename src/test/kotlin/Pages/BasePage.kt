package Pages

import datamodels.Cart
import infrastructure.Driver
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver

open class BasePage {
    constructor()
    constructor(webDriver: WebDriver) {
        this.driver = webDriver
    }
    var url = "https://www.amazon.com"
    lateinit var driver: WebDriver
    var cart = Cart()

    fun setUp() {
        driver = Driver.createDriver()
    }
    fun goToPage() {
        setUp()
        driver.get(url)
    }

    fun searchForString(searchItem: String): SearchResultsPage {
        driver.findElement(By.ByXPath("//input[@id='twotabsearchtextbox']"))
            .sendKeys(searchItem + Keys.RETURN)
        return SearchResultsPage(searchItem, driver)
    }

    fun goToCart(): CartPage {
        driver.findElement(By.xpath("//a[@id='nav-cart']"))
            .click()
        return CartPage(driver)
    }

    fun tearDown() {
        driver.close()
    }
}
