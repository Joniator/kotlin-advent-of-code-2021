fun main() {
    fun count(input: List<Int>): Int {
        var count = 0
        var prev = Integer.MAX_VALUE
        input.forEach {
            if (it > prev) count++
            prev = it
        }
        return count
    }

    fun part1(input: List<String>): Int {
        return count(input.map(Integer::parseInt))
    }

    fun part2(input: List<String>, windowSize: Int = 3): Int {
        val list = input.map(Integer::parseInt)
        val out = mutableListOf<Int>()
        for (i in 0 .. input.size - windowSize) {
            val window = list.drop(i).take(windowSize)
            out.add(window.sum())
        }
        return count(out.toMutableList())
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
