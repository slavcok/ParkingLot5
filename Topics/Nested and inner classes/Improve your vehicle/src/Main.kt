class Vehicle(val name: String) {
    // add name

    // create constructor

    inner class Engine(val horsePower: Int) {
        // add horsePower

        // create constructor

        fun start() {
            println("RRRrrrrrrr....")
        }

        fun printHorsePower() {
            println("The $name vehicle has $horsePower horsepower.")
        }
        // create function printHorsePower()
    }
}