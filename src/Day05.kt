fun main() {

	fun part1(input: List<String>): Int {
		val middle = input.indexOfFirst { it.isBlank() }
		if (middle == -1) {
			return -1

		}
		val fresh = input.subList(0, middle)
		val available = input.subList(middle + 1, input.lastIndex + 1).map { it.toLong() }

		val ranges = IdsRange(fresh)

		return available.count { it in ranges }
	}

	fun part2(input: List<String>): Int {
		return -1
	}

	println(
		part1(
			listOf(
				"3-5",
				"10-14",
				"16-20",
				"12-18",
				" ",
				"1",
				"5",
				"8",
				"11",
				"17",
				"32",
			)
		)
	)

	val input = readInput("Day05")

	part1(input).println()
//	part2(input).println()
}

class IdsRange {
	private var ranges: List<LongRange>

	constructor(ids: List<String>) {
		ranges = ids.map { range ->
			val s = range.split('-')
			LongRange(s[0].toLong(), s[1].toLong())
		}
	}

	operator fun contains(id: Long): Boolean {
		return ranges.any {
			it.contains(id)
		}
	}
}