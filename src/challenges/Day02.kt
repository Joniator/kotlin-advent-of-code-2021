package challenges

import readInput

data class Command(val action: String, val value: Int)

fun parseCommand(input: String): Command {
    val rawInput = input.split(' ')
    return Command(
        action = rawInput[0],
        value = rawInput[1].toInt()
    )
}

fun main() {
    fun part1(input: List<String>): Int {
        var depth = 0
        var horizontal = 0
        input.map { parseCommand(it) }.forEach {
            when (it.action) {
                "forward" -> horizontal += it.value
                "down" -> depth += it.value
                "up" -> depth -= it.value
            }
        }
        return depth * horizontal
    }

    fun part2(input: List<String>): Int {
        var aim = 0
        var depth = 0
        var horizontal = 0
        input.map { parseCommand(it) }.forEach {
            when (it.action) {
                "forward" -> {
                    horizontal += it.value
                    depth += aim * it.value
                }
                "down" -> aim += it.value
                "up" -> aim -= it.value
            }
        }
        return depth * horizontal
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
