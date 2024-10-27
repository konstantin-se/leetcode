package leetcode
fun main() {
    twoSum2(intArrayOf(1, 2, 3, 4, 5, 6), 8)

}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        val residue = target - nums[i]
        if (map.containsKey(residue)) {
            return intArrayOf(map[residue]!!, i)
        }
        map[nums[i]] = i
    }
    throw IllegalArgumentException("No two sum solution")
}


fun twoSum2(nums: IntArray, target: Int): IntArray {
    var hints: MutableMap<Int, Int> = mutableMapOf()
    nums.forEachIndexed { index, num ->
        val possibleHint = target - num
        hints[possibleHint]?.let { return intArrayOf(it, index) }
        hints[num] = index
    }
    throw IllegalArgumentException("No two sum solution")
}

