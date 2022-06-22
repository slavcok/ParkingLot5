// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    val height = readLine()
    val lengthOne = readLine()
    val lengthTwo = readLine()
    val width = readLine()
    println("Box(height=$height, length=$lengthOne, width=$width)")
    println("Box(height=$height, length=$lengthTwo, width=$width)")
}