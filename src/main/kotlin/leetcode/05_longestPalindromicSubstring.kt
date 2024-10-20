fun main() {
    var result = longestPalindrome("qwerty666ytrewq7")
    println(result)
}

fun longestPalindrome(string: String): String {
    var maxLongPalindrome = ""

    for (charIndex in string.indices) {

        getLongPalindrome(string, charIndex, charIndex).let {
            if (it.length > maxLongPalindrome.length)
                maxLongPalindrome = it
        }
        if (charIndex + 1 < string.length) {
            getLongPalindrome(string, charIndex, charIndex + 1).let {
                if (it.length > maxLongPalindrome.length)
                    maxLongPalindrome = it
            }
        }

    }
    return maxLongPalindrome
}


fun getLongPalindrome(string: String, start: Int, end: Int): String {
    var i = 0

    while (start - i >= 0 && end + i < string.length && string[start - i] == string[end + i]  )
        i += 1

    val validStart = start - (i - 1)
    val validEnd = end + (i - 1) + 1

    return if (validEnd > validStart) string.substring(validStart, validEnd) else ""

}
