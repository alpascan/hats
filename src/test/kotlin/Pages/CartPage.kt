package Pages

import datamodels.Item
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.Select

class CartPage(webDriver: WebDriver): BasePage() {
    init {
        this.driver = webDriver
    }

    fun changeQualityOf(item: Item, toQuantity: Int) {
        val quantityButton = Select(
            driver.findElement(
                By.xpath(
                    "//span[contains(text(),'" +
                            item.name.substringAfterLast("'") + "')]" + //only fetch text after escape character
                "/ancestor::div[@data-price='" + "%.2f".format(item.price) + "']" +
                "//Select[@name='quantity']")))
        quantityButton.selectByVisibleText(toQuantity.toString())
    }

    fun getTotal() = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']/span"))
        .getText().substringAfter(' ')
        .toFloat()
}