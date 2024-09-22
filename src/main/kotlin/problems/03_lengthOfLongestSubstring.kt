fun main() {

    println(lengthOfLongestSubstring2("qwertyuiopasdsfghjklzxcvbnm"))

}

fun lengthOfLongestSubstring(s: String): Int {
    var maxLength = 0
    var left = 0
    val seenChars = mutableSetOf<Char>()

    for (right in s.indices) {
        while (s[right] in seenChars) {
            seenChars.remove(s[left])
            left++
        }
        seenChars.add(s[right])
        maxLength = maxOf(maxLength, right - left + 1)
    }

    return maxLength
}


fun lengthOfLongestSubstring2(s: String): Int {
    var longest = 0
    var left = 0

    for (right in 0 until s.length) {
        var leftIndex = s.indexOf(s[right], left)

        if (leftIndex != right) {
            left = leftIndex + 1
        }

        longest = Math.max(longest, right - left + 1)
    }

    return longest
}