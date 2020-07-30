package com.coffee.gourmet

class Coffee(p_code: String, p_desc: String, p_price: Double, p_country: String, p_type: String, p_flavor: String,
    p_aroma: String, p_acidity: String, p_body: String) : Product(p_code, p_desc, p_price) {

    var countryOfOrigin : String = p_country

    var typeOfRoast : String = p_type

    var flavor : String = p_flavor

    var aroma : String = p_aroma

    var acidity : String = p_acidity

    var body : String = p_body

    override fun toString(): String {
        return "${super.toString()}, countryOfOrigin: $countryOfOrigin, typeOfRoast: $typeOfRoast, flavor: $flavor, " +
                "aroma: $aroma, acidity: $acidity, body: $body"
    }

}
