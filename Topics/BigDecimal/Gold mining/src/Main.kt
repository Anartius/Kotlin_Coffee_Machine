fun main() {
    val dwallin = readLine()!!.toBigDecimal()
    val ballin = readLine()!!.toBigDecimal()
    val thorin = readLine()!!.toBigDecimal()

    val totalGold = dwallin.plus(ballin.plus(thorin))
    println(totalGold)

}