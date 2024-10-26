package leetcode


fun main() {
    var result = myAtoi2("-000000000003.14159")


    println(result)

}

fun myAtoi(s: String): Int {
    var number = ""
    var str = s.replace(".","").trim()
    var isNegative = false

    str.forEachIndexed { index, it ->
        if (index == 0) {
            if (it == '-') {
                isNegative = true
            }
            if ( str.length < 2 && !str[index+1].isDigit() ) {
                return returnResult(it.toString(), isNegative)
            }
            if ( str.length < 2 || !str[index+1].isDigit() ) {
                return 0
            } else if (it.isDigit()) {
                number += it
            }
        } else if (it.isDigit()) {
            number += it
        } else if (number.isNotEmpty() && !it.isDigit() ) {
            return returnResult(number, isNegative)
        }
    }

    return returnResult(number, isNegative)
}

fun returnResult(number: String, isNegative: Boolean): Int {
    val numberLong =  if (number.isNotEmpty()) number.toBigDecimal() else return 0
    if (numberLong > Int.MAX_VALUE.toBigDecimal()) return if (isNegative) Int.MIN_VALUE else Int.MAX_VALUE
    return if(isNegative) -numberLong.toInt() else numberLong.toInt()
}

fun myAtoi2(s: String): Int {
    var index = 0
    var sign = 1
    var result = 0
    val maxDiv10 = Int.MAX_VALUE / 10

    // Step 1: Ignore leading whitespace
    while (index < s.length && s[index] == ' ') {
        index++
    }

    // Step 2: Determine the sign
    if (index < s.length && (s[index] == '-' || s[index] == '+')) {
        sign = if (s[index] == '-') -1 else 1
        index++
    }

    // Step 3: Conversion - Read digits and ignore non-digits
    while (index < s.length && s[index].isDigit()) {
        val digit = s[index] - '0'

        // Step 4: Rounding - Check for overflow or underflow
        if (result > maxDiv10 || (result == maxDiv10 && digit > 7)) {
            return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
        }

        result = result * 10 + digit
        index++
    }

    return result * sign
}