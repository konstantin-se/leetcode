fun main() {

    val nums1 = intArrayOf(1,100,101,103)
    val nums2 = intArrayOf(2,3,4,5,6, 7,8,9,11,12, 13,14,15,16,17,18)
    val result =findMedianSortedArrays(nums1, nums2)
    println(result)
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    if (nums1.size > nums2.size) {
        return findMedianSortedArrays(nums2, nums1)
    }

    val m = nums1.size
    val n = nums2.size
    var low = 0
    var high = m

    var halfLengthOfArray= (m + n +1) / 2

    while (low <= high) {
        val partition1 = (low + high) / 2
        val partition2 = halfLengthOfArray - partition1

        val left1 = if (partition1 == 0) Int.MIN_VALUE else nums1[partition1 - 1]
        val right1 = if (partition1 == m) Int.MAX_VALUE else nums1[partition1]

        val left2 = if (partition2 == 0) Int.MIN_VALUE else nums2[partition2 - 1]
        val right2 = if (partition2 == n) Int.MAX_VALUE else nums2[partition2]


        if (left1 <= right2 && left2 <= right1) {
            if ((m + n) % 2 == 1) {
                return maxOf(left1, left2).toDouble()
            } else {
                return (maxOf(left1, left2) + minOf(right1, right2)) / 2.0
            }
        } else if (left1 > right2) {
            high = partition1 - 1
        } else {
            low = partition1 + 1
        }
    }

    throw IllegalArgumentException("Input arrays are not sorted")
}

