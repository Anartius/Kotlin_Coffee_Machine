enum class Countries(val currency: String) {
    GERMANY("Euro"),
    MALI("CFA franc"),
    DOMINICA("Eastern Caribbean dollar"),
    CANADA("Canadian dollar"),
    SPAIN("Euro"),
    AUSTRALIA("Australian dollar"),
    BRAZIL("Brazilian real"),
    SENEGAL("CFA franc"),
    FRANCE("Euro"),
    GRENADA("Eastern Caribbean dollar"),
    KIRIBATI("Australian dollar");

    companion object {
        fun kindOfCurrency(country: String) : String {
            for (enum in values()) {
                if (enum.name == country) return enum.currency
            }
            return  ""
        }
    }
}

fun main() {
    val input = readLine()!!.uppercase().split(" ").toList()

    println( Countries.kindOfCurrency(input[0]) ==
            Countries.kindOfCurrency(input[1]) &&
            input[0].isNotEmpty() && input[1].isNotEmpty() )
}