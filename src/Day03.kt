fun main() {
	fun part1(input: List<String>): Int {
		var sum = 0
		input.map { s -> s.map { it.digitToInt() }.toIntArray() }.map { bank ->
			var majorMax = bank[0]
			var minorMax = bank[1]

			for (i in 1..<bank.size) {
				val curr = bank[i]
				if (curr > majorMax && i != bank.size - 1) {
					majorMax = curr
					minorMax = 0
				} else if (curr > minorMax) {
					minorMax = curr
				}
			}

			val voltage = (majorMax.toString() + minorMax.toString())
			sum += voltage.toInt()
		}

		return sum
	}

	fun part2(input: List<String>): Int {
		return -1
	}

	println(
		part1(
			listOf(
				"117654321111981",
				"987654321111111",
				"811111111111119",
				"234234234234278",
				"818181911112111",
			)
		)
	)

	val input = readInput("Day03")

	part1(input).println()
//	part2(input).println()
}

