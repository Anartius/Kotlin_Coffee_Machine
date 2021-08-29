package machine

fun main() {
    val supplies = Supplies(400, 540, 120, 9, 550)

    supplies.printAmount()
    print("Write action (buy, fill, take): ")
    when(readLine()!!) {
        "buy" -> buy(supplies)
        "fill" -> fill(supplies)
        "take" -> take(supplies)
        else -> println("There isn't so action")
    }

}

fun buy(supplies: Supplies) {
    var choice: String
    while (true) {
        print(
            "What do you need to buy? 1 - espresso, 2 - latte, 3 - cappuccino: "
        )
        choice = readLine()!!
        if (choice == "1" || choice == "2" || choice == "3") {
            break
        } else println("There isn't so option, try again!")
    }

    supplies.cups -= 1
    when(choice) {
        "1" -> {
            supplies.water -= 250
            supplies.beans -= 16
            supplies.money += 4
        }
        "2" -> {
            supplies.water -= 350
            supplies.milk -= 75
            supplies.beans -= 20
            supplies.money += 7
        }
        else -> {
            supplies.water -= 200
            supplies.milk -= 100
            supplies.beans -= 12
            supplies.money += 6
        }
    }

    supplies.printAmount()

}

fun fill(supplies: Supplies) {

    print("Write how many ml of water do you want to add: ")
    supplies.water += readLine()!!.toInt()
    print("Write how many ml of milk do you want to add: ")
    supplies.milk += readLine()!!.toInt()
    print("Write how many grams of coffee beans do you want to add: ")
    supplies.beans += readLine()!!.toInt()
    print("Write how many disposable cups of coffee do you want to add: ")
    supplies.cups += readLine()!!.toInt()

    supplies.printAmount()
}

fun take(supplies: Supplies) {

    println("I gave you $${supplies.money}\n")
    supplies.money = 0
    supplies.printAmount()

}

class Supplies (var water: Int, var milk: Int, var beans: Int,
                var cups: Int, var money: Int) {
    fun printAmount() {
        println("""
            The coffee machine has:
            $water of water
            $milk of milk
            $beans of coffee beans
            $cups of disposable cups
            $money of money
            
        """.trimIndent())
    }
}
