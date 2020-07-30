package com.coffee.gourmet

class Sales () {

    private var orders : ArrayList<Order> = ArrayList()

    constructor(list: ArrayList<Order>) : this() {
        this.orders = list
    }

    fun addOrder(order: Order) {
        this.orders.add(order)
    }

    fun getAllOrder(): ArrayList<Order> {
        return this.orders
    }

    fun getNumberOfOrders(): Int {
        return this.orders.size
    }

}
