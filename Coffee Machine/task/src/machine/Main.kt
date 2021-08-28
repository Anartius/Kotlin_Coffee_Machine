package machine

fun main() {

    // User input
    println("Write how many ml of water the coffee machine has: ")
    val totalWater = readLine()!!.toInt()

    println("Write how many ml of milk the coffee machine has: ")
    val totalMilk = readLine()!!.toInt()

    println("Write how many grams of coffee beans " +
            "the coffee machine has: ")
    val totalBeansWeight = readLine()!!.toInt()

    println("Write how many cups of coffee do you will need: ")
    val requiredCups = readLine()!!.toInt()

    // Calculation of amounts of cups
    val availableCups = listOf(
        totalWater / 200,
        totalMilk / 50,
        totalBeansWeight / 15
    ).minOrNull()!!

    // Output result
    println(
        if (availableCups == requiredCups) {
            "Yes, I can make that amount of coffee"
        } else if (availableCups > requiredCups) {
            "Yes, I can make than amount of coffee (and even " +
                    "${availableCups - requiredCups} more than that)"
        } else "No, I can make only $availableCups cups of coffee"
    )
}
