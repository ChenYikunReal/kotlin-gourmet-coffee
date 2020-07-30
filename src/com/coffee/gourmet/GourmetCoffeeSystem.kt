package com.coffee.gourmet

import java.util.Scanner
import java.io.IOException
import java.text.NumberFormat

class GourmetCoffeeSystem () {

    private val currency : NumberFormat = NumberFormat.getCurrencyInstance()

    private val scanner : Scanner = Scanner(System.`in`)

    private var catalog : Catalog = Catalog()

    private var currentOrder : Order = Order()

    private var sales: Sales = Sales()

    init {
        load()
        println("Welcome to Gourmet Coffee System!")
    }

    private fun load() {
        catalog.addProduct(
            Coffee(
                "C001", "Colombia, Whole, 1 lb", 17.99, "Colombia",
                "Medium", "Rich and Hearty", "Rich", "Medium", "Full"
            )
        )
        catalog.addProduct(
            Coffee(
                "C002", "Colombia, Ground, 1 lb", 18.75, "Colombia",
                "Medium", "Rich and Hearty", "Rich", "Medium", "Full"
            )
        )
        catalog.addProduct(
            Coffee(
                "C003", "Italian Roasts, Whole, 1 lb", 16.80, "Latin American Blend",
                "Italian Roast", "Dark and heavy", "Intense", "Low", "Medium"
            )
        )
        catalog.addProduct(
            Coffee(
                "C004", "Italian Roasts, Ground, 1 lb", 17.55, "Latin American Blend",
                "Italian Roast", "Dark and heavy", "Intense", "Low", "Medium"
            )
        )
        catalog.addProduct(
            Coffee(
                "C005", "French Roasts, Whole, 1 lb", 16.80, "Latin American Blend",
                "French Roast", "Bittersweet, full intense", "Intense, full", "None", "Medium"
            )
        )
        catalog.addProduct(
            Coffee(
                "C006", "French Roasts, Ground, 1 lb", 17.55, "Latin American Blend",
                "French Roast", "Bittersweet, full intense", "Intense, full", "None", "Medium"
            )
        )
        catalog.addProduct(
            Coffee(
                "C007", "Guatemala, Ground, 1 lb", 17.99, "Guatemala",
                "Medium", "Rich and complex", "Spicy", "Medium to high", "Medium to full"
            )
        )
        catalog.addProduct(
            Coffee(
                "C008", "Guatemala, Ground, 1 lb", 18.75, "Guatemala",
                "Medium", "Rich and complex", "Spicy", "Medium to high", "Medium to full"
            )
        )
        catalog.addProduct(
            Coffee(
                "C009", "Guatemala, Whole, 1 lb", 19.99, "Sumatra",
                "Medium", "Vibrant and powdery", "Like dark chocolate", "Gentle", "Rich and full"
            )
        )
        catalog.addProduct(
            Coffee(
                "C010", "Guatemala, Ground, 1 lb", 20.50, "Sumatra",
                "Medium", "Vibrant and powdery", "Like dark chocolate", "Gentle", "Rich and full"
            )
        )
        catalog.addProduct(
            Coffee(
                "C011", "Special Blend, Whole, 1 lb", 16.80, "Latin American Blend",
                "Dark roast", "Full, roasted flavor", "Hearty", "Bold and rich", "Full"
            )
        )
        catalog.addProduct(
            Coffee(
                "C012", "Special Blend, Ground, 1 lb", 17.55, "Latin American Blend",
                "Dark roast", "Full, roasted flavor", "Hearty", "Bold and rich", "Full"
            )
        )
        catalog.addProduct(
            CoffeeBrewer(
                "B001", "Home Coffee Brewer", 150.0,
                "Brewer 100", "Pourover", 6
            )
        )
        catalog.addProduct(
            CoffeeBrewer(
                "B002", "Coffee Brewer, 2 Warmers", 200.0,
                "Brewer 200", "Pourover", 12
            )
        )
        catalog.addProduct(
            CoffeeBrewer(
                "B003", "Coffee Brewer, 3 Warmers", 280.0,
                "Brewer 210", "Pourover", 12
            )
        )
        catalog.addProduct(
            CoffeeBrewer(
                "B004", "Commercial Brewer, 20 cups", 380.0,
                "Quick Coffee 100", "Automatic", 20
            )
        )
        catalog.addProduct(
            CoffeeBrewer(
                "B005", "Commercial Brewer, 40 cups", 480.0,
                "Quick Coffee 200", "Automatic", 40
            )
        )
        catalog.addProduct(Product("A001", "Almond Flavored Syrup", 9.0))
        catalog.addProduct(Product("A002", "Irish Creme Flavored Syrup", 9.0))
        catalog.addProduct(Product("A003", "Mint Flavored syrup", 9.0))
        catalog.addProduct(Product("A004", "Caramel Flavored Syrup", 9.0))
        catalog.addProduct(Product("A005", "Gourmet Coffee Cookies", 12.0))
        catalog.addProduct(Product("A006", "Gourmet Coffee Travel Thermo", 18.0))
        catalog.addProduct(Product("A007", "Gourmet Coffee Ceramic Mug", 8.0))
        catalog.addProduct(Product("A008", "Gourmet Coffee 12 Cup Filters", 15.0))
        catalog.addProduct(Product("A009", "Gourmet Coffee 36 Cup Filters", 45.0))
    }

    @Throws(IOException::class)
    fun run() {
        var choice = this.getChoice()
        while (choice != 0) {
            when (choice) {
                1 -> this.displayCatalog()
                2 -> this.displayProductInformation()
                3 -> this.displayOrder()
                4 -> this.addOrModifyProduct()
                5 -> this.removeProduct()
                6 -> this.saleOrder()
                7 -> this.displayOrdersSold()
            }
            choice = this.getChoice()
        }
        scanner.close()
    }

    /**
     * 主菜单
     * 0 -> 退出系统
     * 1 -> 显示目录：列出每个产品的代码和描述
     * 2 -> 显示产品
     * 3 -> 显示当前订单：列出当前订单中每个产品的数量、代码和价格，以及订单总价格
     * 4 -> 将产品添加到当前订单,如果指定的产品已经是订单的一部分，此命令将修改该产品的数量
     * 5 -> 从当前订单中删除产品
     * 6 -> 注册当前订单的销售此命令将订单添加到商店的销售中并清空当前订单
     * 7 -> 显示销售：列出所有已售出的订单
     */
    private fun printMainMenu() {
        print(
            "[0]  Quit\n[1]  Display catalog\n[2]  Display product\n[3]  Display current order\n" +
                    "[4]  Add|modify product to|in current order\n[5]  Remove product from current order\n"
                    + "[6]  Register sale of current order\n[7]  Display sales\nYour Choice>"
        )
    }

    @Throws(IOException::class)
    private fun getChoice():Int {
        while (true) {
            try {
                println()
                printMainMenu()
                val choice = Integer.parseInt(scanner.next())
                println()
                if (choice in 0..7) {
                    return choice
                }
                println("Invalid choice:  $choice")
            }
            catch (numberFormatException:NumberFormatException) {
                println(numberFormatException)
            }
        }
    }

    /**
     * 打印所有产品信息
     */
    private fun displayCatalog() {
        val numberOfProducts = this.catalog.getNumberOfProducts()
        if (numberOfProducts == 0) {
            println("The catalog is empty")
        } else {
            for (product in this.catalog.getAllProduct()) {
                println("${product.code} ${product.description}")
            }
        }

    }

    /**
     * 打印所选产品信息
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun displayProductInformation() {
        val product = this.readProduct()
        if (product != null) {
            println("  Description: ${product.description}")
            println("  Price: ${product.price}")
            if (product is Coffee) {
                //进行强制类型转换
                val coffee = product as Coffee?
                //输出咖啡产品信息
                println("  Origin: ${coffee!!.countryOfOrigin}")
                println("  Roast: ${coffee.typeOfRoast}")
                println("  Flavor: ${coffee.flavor}")
                println("  Aroma: ${coffee.aroma}")
                println("  Acidity: ${coffee.acidity}")
                println("  Body: ${coffee.body}")
            } else if (product is CoffeeBrewer) {
                val coffeeBrewer = product as CoffeeBrewer?
                println("  Model: ${coffeeBrewer!!.modelOfTheBrewer}")
                println("  Water Supply: ${coffeeBrewer.typeOfTheWaterSupply}")
                println("  Number of Cups: ${coffeeBrewer.numberOfCups}")
            }
        } else {
            println("There are no products with that code")
        }

    }

    /**
     * 打印订单信息
     */
    private fun displayOrder() {
        val numberOfOrderItems = this.currentOrder.getNumberOfOrderItems()
        if (numberOfOrderItems == 0) {
            println("The current order is empty")
        } else {
            for (orderItem in this.currentOrder.getAllOrderItem()) {
                println(orderItem.toString())
            }
            println("Total: " + currency.format(this.currentOrder.getValue()))
        }

    }

    /**
     * 添加或修改订单中产品信息
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun addOrModifyProduct() {
        val product = this.readProduct()
        if (product != null) {
            val quantity = this.readQuantity()
            val orderItem = this.currentOrder.getOrderItem(product)
            if (orderItem == null) {
                this.currentOrder.addOrderItem(OrderItem(product, quantity))
                println("The product ${product.code} has been added")
            } else {
                orderItem.quantity = quantity
                println("The quantity of the product ${product.code} has been modified")
            }
        } else {
            println("There are no products with that code")
        }

    }

    /**
     * 清除订单信息中某一产品信息
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun removeProduct() {
        val product = this.readProduct()
        if (product != null) {
            val orderItem = this.currentOrder.getOrderItem(product)
            if (orderItem != null) {
                this.currentOrder.removeOrderItem(orderItem)
                println("The product ${product.code} has been removed from the current order")
            } else {
                println("There are no products in the current order with that code")
            }
        } else {
            println("There are no products with that code")
        }
    }

    /**
     * 交易当前订单
     */
    private fun saleOrder() {
        if (this.currentOrder.getNumberOfOrderItems() > 0) {
            this.sales.addOrder(this.currentOrder)
            this.currentOrder = Order()
            println("The sale of the order has been registered")
        } else {
            println("The current order is empty")
        }
    }

    /**
     * 展示交易过的订单
     */
    private fun displayOrdersSold() {
        val numberOfOrders = this.sales.getNumberOfOrders()
        if (numberOfOrders != 0) {
            var count = 1
            for (order in this.sales.getAllOrder()) {
                println("Order " + count++)
                for (orderItem in this.currentOrder.getAllOrderItem()) {
                    println("   $orderItem")
                }
                println("   Total: ${currency.format(order.getValue())}")
            }
        } else {
            println("There are no sales")
        }

    }

    /**
     * 读取要检索的产品
     * @return 要检索的产品
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun readProduct():Product? {
        print("Product code> ")
        return this.catalog.getProduct(scanner.next())
    }

    /**
     * 读取购买数
     * @return 购买数
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun readQuantity():Int {
        while (true) {
            try {
                print("Quantity> ")
                val quantity = Integer.parseInt(scanner.next())
                if (quantity > 0) {
                    return quantity
                }
                println("Invalid input. Please enter a positive integer")
            }
            catch (e:NumberFormatException) {
                println(e)
            }
        }
    }

}
