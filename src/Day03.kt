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

	fun part2(input: List<String>): Long {
		var sum = 0L
		input.map { s -> s.map { it.digitToInt() }.toIntArray() }.map { bank ->
			val bankSize = bank.size - 1
			val majorArr = IntArray(12)
			val majorLen = majorArr.size - 1

			outer@ for (i in 0..bankSize) {
				val curr = bank[i]
				for ((idx, major) in majorArr.withIndex()) {
					if (curr > major && majorLen - idx <= bankSize - i) {
						majorArr[idx] = curr
						majorArr.fill(0, idx + 1)
						continue@outer
					}
				}
			}

			val voltage = majorArr.joinToString("") { it.toString() }
			sum += voltage.toLong()
		}

		return sum
	}

	println(
		part2(
			listOf(
				"987654321111111",
				"811111111111119",
				"234234234234278",
				"818181911112111",
			)
		)
	)

	val input = readInput("Day03")

	part1(input).println()
	part2(input).println()
}

