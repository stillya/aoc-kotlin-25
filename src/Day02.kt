fun main() {
	fun part1(input: String): Long {
		var result = 0L
		input.split(",").map { s ->
			s.split("-").let {
				result += ProductSequence(it[0].toLong(), it[1].toLong()).invalidIds()
			}
		}

		return result
	}

	fun part2(input: String): Long {
		var result = 0L
		input.split(",").map { s ->
			s.split("-").let {
				result += ProductSequence(it[0].toLong(), it[1].toLong()).invalidIds2()
			}
		}

		return result
	}

	println(
		// 11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124
		part2("11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124")
	)

	val input = readInput("Day02").first()

	part1(input).println()
	part2(input).println()
}

class ProductSequence(
	var start: Long,
	val end: Long
) {
	fun invalidIds(): Long {
		var result = 0L
		while (start <= end) {
			val startStr = start.toString()
			if (startStr.length % 2 == 0) {
				val firstPart = startStr.take(startStr.length / 2)
				val secondPart = startStr.substring(startStr.length / 2, startStr.length)
				if (firstPart.toLong() == secondPart.toLong()) {
					result += start
				}
			}
			start++
		}

		return result
	}

	fun invalidIds2(): Long {
		var result = 0L
		outer@ while (start <= end) {
			val startStr = start.toString()
			for (i in listOf(2, 3)) {
				if (startStr.length % i == 0) {
					var chunkSize = startStr.length / i
					do {
						val ngrams = startStr.chunked(chunkSize)
						if (ngrams.distinct().size == 1) {
							result += start
							start++
							continue@outer
						}
						chunkSize /= i
					} while (chunkSize > 1)
				}
			}
			if (isPrime(startStr.length)) {
				val chunkSize = 1
				val ngrams = startStr.chunked(chunkSize)
				if (ngrams.distinct().size == 1) {
					result += start
					start++
					continue@outer
				}

			}
			start++
		}

		return result
	}

	fun isPrime(n: Int): Boolean {
		if (n < 2) return false
		if (n == 2) return true
		if (n % 2 == 0) return false

		for (i in 3..kotlin.math.sqrt(n.toDouble()).toInt() step 2) {
			if (n % i == 0) return false
		}
		return true
	}

}