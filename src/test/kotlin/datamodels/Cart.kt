package datamodels

class Cart() {
    val itemList = mutableListOf<Item>()

    fun addItemToCart(item: Item, quantity: Int = 1) {
        repeat(quantity) {
            itemList.add(item)
        }
    }

    fun addItemToCart(name: String, price: Float, quantity: Int = 1) {
        addItemToCart(Item(name, price), quantity)
    }

    fun addItemToCart(name: String, price: String, quantity: Int = 1) {
        addItemToCart(Item(name, price.toFloat()), quantity)
    }
    fun removeItemFromCart(item: Item, quantity: Int = 1, allItems: Boolean = false) {
        if (allItems) {
            itemList.removeAll(itemList.filter { it == item })
        } else {
            repeat(quantity) {
                itemList.remove(item)
            }
        }
    }

    fun removeItemFromCart(name: String, quantity: Int = 1, allItems: Boolean = false) {
        removeItemFromCart(getItemByName(name), quantity, allItems)
    }

    fun removeItemFromCartbyTag(tag: String, quantity: Int = 1, allItems: Boolean = false) {
        removeItemFromCart(getItemByTag(tag), quantity, allItems)
    }
    fun getItemByName(name: String): Item {
        return itemList.filter { it.name == name }.first()
    }

    fun getItemByTag(tag: String): Item {
        return itemList.filter { it.searchTag == tag }.first()
    }

    fun getTotal(): Float {
        var total = 0F
        for (item in itemList) {
            total += item.price
        }
        return "%.2f".format(total).toFloat()
    }
}
