fun main() {
	fun part1(input: List<String>): Int {
		val ring = ModRing(100) // 0 to 99
		var point = 50
		var zeroPoint = 0
		input.map {
			it[0] to it.drop(1).toInt()
		}.forEach { (dir, value) ->
			when (dir) {
				'L' -> {
					point = ring.minus(point, value)
				}

				'R' -> {
					point = ring.add(point, value)
				}
			}
			if (point == 0) {
				zeroPoint++
			}
		}

		return zeroPoint
	}

	fun part2(input: List<String>): Int {
		val ring = ModRing(100) // 0 to 99
		var point = 50
		var wraparounds = 0
		input.map {
			it[0] to it.drop(1).toInt()
		}.forEach { (dir, value) ->
			when (dir) {
				'L' -> {
					when {
						point == 0 -> wraparounds += value / 100
						point <= value -> wraparounds += 1 + (value - point) / 100
					}
					point = ring.minus(point, value)
				}

				'R' -> {
					wraparounds += (point + value) / 100
					point = ring.add(point, value)
				}
			}
		}

		return wraparounds

	}

	val input = readInput("Day01")

	part1(input).println()
	part2(input).println()
}

class ModRing(private val n: Int) {

	private fun norm(x: Int): Int {
		return ((x % n) + n) % n
	}

	fun add(a: Int, b: Int): Int = norm(a + b)

	fun minus(a: Int, b: Int): Int = norm(a - b)

}