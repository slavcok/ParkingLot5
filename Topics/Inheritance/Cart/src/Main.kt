fun main() {
    val productType = readln()
    val price = readln().toInt()
    val product = Product(price)
    println(totalPrice(product))
}

class Product(val price: Int) {

}