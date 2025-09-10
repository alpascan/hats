import Pages.BasePage
import Pages.CartPage
import Pages.ItemPage
import Pages.SearchResultsPage
import cucumber.api.java.After
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import datamodels.Cart
import org.junit.Assert.assertEquals

class StepDefinitions {

    private var homePage = BasePage()
    private var cart = Cart()
    private lateinit var searchPage: SearchResultsPage
    private lateinit var itemPage: ItemPage
    private lateinit var cartPage: CartPage

    @Given("the user is on the website")
    fun goToWebsite() {
        homePage
            .goToPage()
    }

    @When("the user searches for {string}")
    fun searchForString(searchString: String) {
        searchPage = homePage.searchForString(searchString)
    }

    @When("selects the first {string}")
    fun selectTheFirstItem(item: String) {
        itemPage = searchPage.selectFirstItem()
    }

    @When("adds {int} to the cart")
    fun addToTheCart(numberOfItems: Int) {
        cart.addItemToCart(itemPage.getItemDetails(), numberOfItems)
        itemPage.addItemToCart(quantity = numberOfItems)
    }

    @Then("the expected cost should be correct")
    fun validateTotal() {
        cartPage = itemPage.goToCart()
        assertEquals("Cart Total Not expected. Something went Wrong?", cartPage.getTotal(), cart.getTotal())
    }

    @When("the user removes {int} {string} from the cart")
    fun selectItem(numberOfItems: Int, item: String) {
        val requiredItem = cart.getItemByTag(item)
        cartPage.changeQualityOf(requiredItem, numberOfItems)
        cart.removeItemFromCart(requiredItem, numberOfItems)
    }

    @After
    fun tearDown() {
        cartPage.tearDown()
    }
}
