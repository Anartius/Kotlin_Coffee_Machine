enum class Rainbow {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    INDIGO,
    VIOLET;

    companion object {
        fun hasColor(color: String): Boolean {
            for (enum in values()) {
                if (enum.name == color) return true
            }
            return false
        }
    }

}

fun main() {
    val color = readLine()!!.uppercase()
    println(Rainbow.hasColor(color))
}
