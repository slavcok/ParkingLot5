class ChristmasTree(var color: String) {


    fun putTreeTopper(color: String) {

    }

    inner class TreeTopper(var color: String) {
        var _color: String = color
        fun sparkle() {
            println("The sparkling $_color tree topper looks stunning on the ${this@ChristmasTree.color} Christmas tree!")
        }
    }
}