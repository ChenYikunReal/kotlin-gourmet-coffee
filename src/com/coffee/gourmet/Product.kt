package com.coffee.gourmet

open class Product() {

    var code : String = ""

    var description : String = ""

    var price : Double = 0.0

    constructor(p_code: String, p_desc: String, p_price: Double) : this() {
        this.code = p_code
        this.description = p_desc
        this.price = p_price
    }

    override fun hashCode(): Int {
        return code.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Product
        if (code != other.code) return false
        return true
    }

    override fun toString(): String {
        return "code: $code, description: $description, price: $price"
    }

}
