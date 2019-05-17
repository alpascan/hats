package Pages


import datamodels.Item
import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.Select

class ItemPage(webDriver: WebDriver, val searchTag: String): BasePage() {

    init {
        this.driver = webDriver
    }

    fun getItemDetails(): Item {
        var priceString = driver.findElement(By.xpath("//span[@id='priceblock_ourprice']"))
           .getText()
        if (priceString.contains('-')){
            // Item has different sizes
            val sizeDropdown = Select(driver.findElement(By.xpath("//select[@id='native_dropdown_selected_size_name']")))
            sizeDropdown.selectByIndex(1)
            priceString = driver.findElement(By.xpath("//span[@id='priceblock_ourprice']"))
                .getText()
        }
        val price = priceString.substringBefore(' ')
            .substringAfter('$')
            .toFloat()
        val name = driver.findElement(By.xpath("//span[@id='productTitle']"))
            .getText()
        return Item(name, price, searchTag)
    }

    fun selectQuantity(quantity: Int) {
        val quantityDropdown = Select(driver.findElement(By.xpath("//select[@id='quantity']")))
        quantityDropdown.selectByVisibleText(quantity.toString())
    }

    fun addItemToCart(quantity: Int = 1) {
        if (quantity > 1) {
            try {
                val only1leftInStock =
                    driver.findElement(By.xpath("//*[text()[contains(.,'Only 1 left')]]\n")).isDisplayed
                if (only1leftInStock) {
                    throw UnsupportedOperationException("Case not implemented yet")
                }
            } catch (e: NoSuchElementException) {
                //TODO: Modify test to support Only one item supported
            }
            selectQuantity(quantity)
        }
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']"))
            .click()
    }
}