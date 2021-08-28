package machine

fun main() {
    println("Write how many cups of coffee do you will need: ")
    val totalCups = readLine()!!.toInt()
    println("""
        For $totalCups cups of coffee you will need:
        ${totalCups * 200} ml of water
        ${totalCups * 50} ml of milk
        ${totalCups * 15} g of coffee beans
    """.trimIndent())
}
