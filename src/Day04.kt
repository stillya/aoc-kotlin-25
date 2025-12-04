fun main() {

	fun part1(input: List<String>): Int {
		val grid: Array<Array<Char>> = input.map { it.toCharArray().toTypedArray() }.toTypedArray()

		var total = 0
		for (row in grid.indices) {
			for (col in grid[row].indices) {
				if (grid[row][col] == ROLL && isAccessed(grid, Pair(row, col))) {
					total++
				}
			}
		}

		return total
	}

	fun part2(input: List<String>): Int {
		val grid: Array<Array<Char>> = input.map { it.toCharArray().toTypedArray() }.toTypedArray()

		var total = 0

		do {
			var lastTotal = 0
			for (row in grid.indices) {
				for (col in grid[row].indices) {
					if (grid[row][col] == ROLL && isAccessed(grid, Pair(row, col))) {
						lastTotal++
						grid[row][col] = '.'
					}
				}
			}
			total += lastTotal
		} while (lastTotal > 0)

		return total
	}

	println(
		part2(
			listOf(
				"..@@.@@@@.",
				"@@@.@.@.@@",
				"@@@@@.@.@@",
				"@.@@@@..@.",
				"@@.@@@@.@@",
				".@@@@@@@.@",
				".@.@.@.@@@",
				"@.@@@.@@@@",
				".@@@@@@@@.",
				"@.@.@@@.@.",
			)
		)
	)

	val input = readInput("Day04")

	part1(input).println()
	part2(input).println()
}

fun isAccessed(grid: Array<Array<Char>>, idx: Pair<Int, Int>): Boolean {
	val rollsCount = DIRS.count { (dr, dc) ->
		val newRow = idx.first + dr
		val newCol = idx.second + dc
		newRow in grid.indices && newCol in grid[0].indices && grid[newRow][newCol] == ROLL
	}

	return rollsCount < 4
}

val DIRS = listOf(
	-1 to 0,   // up
	0 to -1,   // left
	1 to 0,    // down
	0 to 1,    // right
	-1 to -1,  // up-left
	1 to 1,    // down-right
	-1 to 1,   // up-right
	1 to -1    // down-left
)

const val ROLL = '@'
