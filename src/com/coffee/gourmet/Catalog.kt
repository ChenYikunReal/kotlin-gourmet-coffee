package com.coffee.gourmet

class Catalog () {

    private var products : ArrayList<Product> = ArrayList()

    constructor(list: ArrayList<Product>) : this() {
        this.products = list
    }

    fun addProduct(product: Product) {
        this.products.add(product)
    }

    fun getProduct(code: String): Product? {
        for (product in products) {
            if (product.code == code) {
                return product
            }
        }
        return null
    }

    fun getAllProduct(): ArrayList<Product> {
        return this.products
    }

    fun getNumberOfProducts(): Int {
        return this.products.size
    }

}
