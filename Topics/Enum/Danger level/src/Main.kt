enum class DangerLevel(val power: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    fun getLevel() = power
}
