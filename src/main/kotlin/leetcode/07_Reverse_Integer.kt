package leetcode

import kotlin.math.abs


fun main() {
    var result = reverse2(-1234)


    println(result)

}

fun reverse(x: Int): Int {
    if (x == 0) return 0
    var sign = ""
    var xAsStr = x.toString()

    if (xAsStr.first() == '-') {
        sign = "-"
        xAsStr = xAsStr.replace("-", "")
    }
    while (xAsStr.last() == '0')
        xAsStr = xAsStr.dropLast(1)

    var result = "${sign}${xAsStr.reversed()}".toLong()

    if (result < Int.MIN_VALUE || result > Int.MAX_VALUE) {
        result = 0
    }

    return result.toInt()
}

fun reverse2(x: Int): Int {
    var num = abs(x)
    var result = 0

    while (num != 0) {
        val digit = num % 10
        num /= 10

        if (result > (Int.MAX_VALUE - digit) / 10) {
            return 0
        }

        result = result * 10 + digit
    }

    return if (x < 0) -result else result
}