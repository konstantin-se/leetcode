package leetcode

import kotlin.math.abs

fun main() {
    isPalindrome(2000)
}

fun isPalindrome(x: Int): Boolean {
    var number = abs(x)
    var palindromeNumber = 0

    if (x < 0 )
        return false

    while (number != 0) {
        val digit = number % 10
        number /= 10

        palindromeNumber = (palindromeNumber * 10) + digit
    }
    println(palindromeNumber)
    return x == palindromeNumber
}