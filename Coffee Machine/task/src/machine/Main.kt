package machine

class CoffeeMachine {
    val supplies = Supplies(400, 540, 120, 9, 550)

    fun action (userInput: String) {
        when(userInput) {
            "buy" -> buy(supplies)
            "fill" -> fill(supplies)
            "take" -> take(supplies)
            "remaining" -> supplies.printAmount()
            else -> return
        }
        return
    }

    fun checkOfSupplies(choice: String, supplies: Supplies): Boolean {

        val coffee = when(choice) {
            "1" -> listOf(250, 0, 16, 1)
            "2" -> listOf(350, 75, 20, 1)
            else -> listOf(200, 100, 12, 1)
        }
        val ingredients = listOf("water", "milk", "coffee beans", "cups")
        val checkOfSupplies = listOf(supplies.water, supplies.milk, supplies.beans, supplies.cups)

        return if ((checkOfSupplies.zip(coffee) { a, b -> a - b }).minOrNull()!! < 0) {
            for (i in checkOfSupplies.indices) {
                if (checkOfSupplies[i] - coffee[i] < 0) println("Sorry, not enough ${ingredients[i]}\n")
            }
            false
        } else true

    }

    fun buy(supplies: Supplies) {
        var choice: String
        while (true) {
            print(
                "\nWhat do you need to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                        "back - to main menu: "
            )
            choice = readLine()!!
            if (choice == "back") {
                return
            }else if (choice == "1" || choice == "2" || choice == "3") {
                break
            } else println("There isn't so option, try again!")
        }

        if (checkOfSupplies(choice, supplies)) {
            println("I have enough resources, making you a coffee!\n")
            when (choice) {
                "1" -> {
                    supplies.water -= 250
                    supplies.beans -= 16
                    supplies.money += 4
                    supplies.cups -= 1
                }
                "2" -> {
                    supplies.water -= 350
                    supplies.milk -= 75
                    supplies.beans -= 20
                    supplies.money += 7
                    supplies.cups -= 1
                }
                else -> {
                    supplies.water -= 200
                    supplies.milk -= 100
                    supplies.beans -= 12
                    supplies.money += 6
                    supplies.cups -= 1
                }
            }
        }
    }

    fun fill(supplies: Supplies) {

        print("\nWrite how many ml of water do you want to add: ")
        supplies.water += readLine()!!.toInt()
        print("Write how many ml of milk do you want to add: ")
        supplies.milk += readLine()!!.toInt()
        print("Write how many grams of coffee beans do you want to add: ")
        supplies.beans += readLine()!!.toInt()
        print("Write how many disposable cups of coffee do you want to add: ")
        supplies.cups += readLine()!!.toInt()
        println("")

    }

    fun take(supplies: Supplies) {

        println("\nI gave you $${supplies.money}\n")
        supplies.money = 0

    }

    class Supplies (var water: Int, var milk: Int, var beans: Int,
                    var cups: Int, var money: Int) {
        fun printAmount() {
            println(
                """
            The coffee machine has:
            $water of water
            $milk of milk
            $beans of coffee beans
            $cups of disposable cups
            $money of money
            
        """.trimIndent()
            )
        }
    }

}

fun main() {
    val machine = CoffeeMachine()
    var input = ""
    while (true) {
        print("Write action (buy, fill, take, remaining, exit): ")
        input = readLine()!!

        if (input == "exit") return

        machine.action(input)
    }
}