package parking

import java.util.*

fun main() {

    var round = true
    var miniround = true
    var garage = mutableListOf<String>()
    var color = mutableListOf<String>()
    do {
        val input = readLine()!!.toString()
        val first = input.split(" ").first()
        var poradie: Int
        if (first == "exit") {
            round = false
            break
        } else if (first == "reg_by_color" && garage.isNotEmpty()) {
            val (_, b) = input.split(" ")
            var numberOfCar = 0
            for (i in 0 until color.size) {
                if (color[i] == b.lowercase(Locale.getDefault())) {
                    if (numberOfCar > 0) {
                        print(", ")
                    }
                    print(garage[i])
                    numberOfCar += 1
                }
            }
            if (numberOfCar == 0)  {
                println("No cars with color $b were found.")
            } else println()
        } else if (first == "spot_by_color" && garage.isNotEmpty()) {
            val (_, b) = input.split(" ")
            var numberOfCar = 0
            for (i in 0 until color.size) {
                if (color[i] == b.lowercase(Locale.getDefault())) {
                    if (numberOfCar > 0) {
                        print(", ")
                    }
                    print("${i + 1}")
                    numberOfCar += 1
                }
            }
            if (numberOfCar == 0)  {
                println("No cars with color $b were found.")
            } else println()
        } else if (first == "spot_by_reg" && garage.isNotEmpty()) {
            val (_, b) = input.split(" ")
            var numberOfCar = 0
            for (i in 0 until garage.size) {
                if (garage[i] == b.lowercase(Locale.getDefault())) {
                    println("${i + 1}")
                    numberOfCar += 1
                }
            }
            if (numberOfCar == 0)  {
                println("No cars with registration number $b were found.")
            }
        } else if (first == "create") {
            val (_, b) = input.split(" ")
            if (garage.size > 0) {
                for (i in 0 until garage.size) {
                    garage.removeLast()
                    color.removeLast()
                }
            }
            for (i in 0..b.toInt()) {
                garage.add("")
                color.add("")
            }
            if (b.toInt() > 1) {
                println("Created a parking lot with $b spots.")
            } else  {
                println("Created a parking lot with $b spots.")
            }
        } else if (first == "park" && garage.isNotEmpty()) {
            val (_, b, c) = input.split(" ")
            poradie = 0
            do {
                if (poradie >= garage.size - 1) {
                    println("Sorry, the parking lot is full.")
                    miniround = false
                } else if (garage[poradie] == "") {
                    garage[poradie]= b.lowercase(Locale.getDefault())
                    color[poradie]= c.lowercase(Locale.getDefault())
                    println("${color[poradie]} car parked in spot ${poradie + 1}.")
                    miniround = false
                }
                poradie += 1
            } while (miniround)
            miniround = true
        } else if (first == "leave" && garage.isNotEmpty()){
            val (_, b) = input.split(" ")
            val bb = b.toInt()
            if (garage[bb - 1] == ""){
                println("There is no car in spot $bb.")
            } else {
                println("Spot $bb is free.")
                garage[bb - 1] = ""
                color[bb - 1] = ""
            }
        } else if (first == "status" && garage.size > 0){
            var wasPrinted = false
                for (i in 0 until garage.size) {
                    if (garage[i] != "") {
                        println("${i + 1} ${garage[i]} ${color[i]}")
                        wasPrinted = true
                    }
                }
            if (!wasPrinted){
                println("Parking lot is empty.")
            }
        } else {
           println("Sorry, a parking lot has not been created.")
        }
    } while (round)
}
