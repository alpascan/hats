package Pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class SearchResultsPage(val searchItem: String, driver: WebDriver) : BasePage() {
    init {
        this.driver = driver
    }

    fun selectFirstItem(): ItemPage {
        driver.findElement(By.xpath("//div[@class='s-result-list sg-row']/div[1]"))
            .click()
        return ItemPage(driver, searchItem)
    }
}
