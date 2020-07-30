package com.coffee.gourmet

class OrderItem () {

    lateinit var product : Product

    var quantity : Int = 0

    constructor(product: Product, quantity: Int) : this() {
        this.product = product
        this.quantity = quantity
    }

    fun getValue(): Double {
        return product.price * quantity
    }

    override fun hashCode(): Int {
        var result = product.hashCode() ?: 0
        result = 31 * result + quantity
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as OrderItem
        if (product != other.product) return false
        if (quantity != other.quantity) return false
        return true
    }

    override fun toString(): String {
        return "code: ${product.code}, price: ${product.price}, quantity: $quantity"
    }

}
