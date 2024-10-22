package leetcode

fun main() {
    var result = convert("ABCCBAF", 2)


    println(result)

}

fun convert(s: String, numRows: Int): String {
    if (s.length <= 1 || numRows == 1) {
        return s
    }
    val arrayOfArrays = Array(numRows) { Array(s.length) { "" } }
    var row = 0
    var column = 0
    var stringPos = 0


    while (stringPos < s.length) {
        arrayOfArrays[row][column] = s[stringPos].toString()
        if (row == numRows - 1) {
            while (row != 0) {
                row -= 1
                column += 1
                stringPos += 1
                if (stringPos < s.length) {
                    arrayOfArrays[row][column] = s[stringPos].toString()
                }

            }
        } else {
            row += 1
            stringPos += 1
        }

    }
    return arrayOfArrays.map {
        it.filter {
            it != ""
        }.joinToString("")
    }.joinToString("")
}