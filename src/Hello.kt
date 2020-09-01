fun sum(x: Int, y: Int): Int = x * y

fun printPattern(char: Char = '*', number: Int = 5) {
    repeat(number) {
        print(char)
    }
}

fun main() {
    val x = 1
    val y = 2
    println("x + y = ${sum(x, y)}")
    printPattern(number = 7)
}