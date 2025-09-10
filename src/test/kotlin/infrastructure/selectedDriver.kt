package infrastructure

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

object Driver {
    private val browser = System.getProperty("browser")
    fun createDriver(): WebDriver {
        when (browser) {
            "chrome" -> {
                WebDriverManager.chromedriver().setup()
                return ChromeDriver()
            }
            "firefox" -> {
                WebDriverManager.firefoxdriver().setup()
                return FirefoxDriver()
            }
            else -> throw RuntimeException("Browser not supported!")
        }
    }
    // TODO: Implement wait times to fix firefox flakyness
}
