enum class Rainbow {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    INDIGO,
    VIOLET
}

fun main() {
    val color = readLine()!!.uppercase()
    println(Rainbow.valueOf(color).ordinal + 1)
}