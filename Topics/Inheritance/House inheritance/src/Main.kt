const val MIL = 1000000
fun main() {
    val rooms = readLine()!!.toInt()
    val price = readLine()!!.toInt()
    val house = House(rooms, price)
    println(totalPrice(house))
}

data class House(val rooms: Int, val price: Int)

fun totalPrice(house: House): Int {
    val coefficient: Double = when (house.rooms) {
        in Int.MIN_VALUE..1 -> 1.0
        in 2..3 -> 1.2
        4 -> 1.25
        in 5..7 -> 1.4
        in 8..MIL -> 1.6
        else -> 1.0
    }
    var basePrice = house.price
    if (house.price in Int.MIN_VALUE..0) {
        basePrice = 0
    } else if (house.price > MIL) {
        basePrice = MIL
    }
    return ((basePrice * coefficient).toInt())
}