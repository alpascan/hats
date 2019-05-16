package datamodels

data class Item(
    var name: String,
    var price: Float,
    var searchTag: String = ""
)