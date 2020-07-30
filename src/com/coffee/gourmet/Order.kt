package com.coffee.gourmet

class Order () {

    private var orderItemList : ArrayList<OrderItem> = ArrayList()

    constructor(list: ArrayList<OrderItem>) : this() {
        this.orderItemList = list
    }

    fun addOrderItem(orderItem: OrderItem) {
        this.orderItemList.add(orderItem)
    }

    fun removeOrderItem(orderItem: OrderItem) {
        this.orderItemList.remove(orderItem)
    }

    fun getAllOrderItem(): ArrayList<OrderItem> {
        return this.orderItemList
    }

    fun getOrderItem(product: Product): OrderItem? {
        for (orderItem in orderItemList) {
            if (orderItem.product == product) {
                return orderItem
            }
        }
        return null
    }

    fun getNumberOfOrderItems(): Int {
        return this.orderItemList.size
    }

    fun getValue(): Double {
        var value = 0.0
        for (orderItem in orderItemList) {
            value += orderItem.getValue()
        }
        return value
    }

}
