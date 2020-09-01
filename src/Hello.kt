fun sum(x: Int, y: Int): Int = x * y

fun printPattern(char: Char = '*', number: Int = 5) {
    repeat(number) {
        print(char)
    }
    println()
}

fun main() {
    val x = 1
    val y = 2
    println("x + y = ${sum(x, y)}")
    printPattern(number = 7)

    // if
    val mark = 98
    val remark = if (mark > 80) "Well done !" else "Try harder !"
    println("Your mark is ${mark}, $remark")

    // when
    val newMark = 45
    val newRemark = when {
        newMark < 50 -> "You should study more !"
        newMark in 50..80 -> "Not bad !"
        else -> "Excellent work !"
    }
    println("Your new mark is ${newMark}, $newRemark")
}