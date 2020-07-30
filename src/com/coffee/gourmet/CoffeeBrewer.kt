package com.coffee.gourmet

class CoffeeBrewer(p_code: String, p_desc: String, p_price: Double, p_model: String, p_type: String, p_num: Int) :
    Product(p_code, p_desc, p_price) {

    var modelOfTheBrewer : String = p_model

    var typeOfTheWaterSupply : String = p_type

    var numberOfCups : Int = p_num

    override fun toString(): String {
        return "${super.toString()}, modelOfTheBrewer: $modelOfTheBrewer, typeOfTheWaterSupply: $typeOfTheWaterSupply" +
                ", numberOfCups: $numberOfCups"
    }

}
