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

    fun reply(input: String) = when (input) {
        "y", "yes" -> "I'm glad you agree"
        "n", "no" -> "Sorry to hear that"
        else -> "I don't understand"
    }

    println(reply("yes"))
    println(reply("n"))
    println(reply("fuck"))

    // when with objects
//    when (val pet = getMyPet()) {
//        is Cato -> pet.meow() // smart casting
//        is Dogo -> pet.woof() // smart casting
//    }

    // loops
    // while, do-while same as java

    // for with list
    val list = listOf("a", "b", "c")
    for (s in list)
        println(s)

    for ((index, elem) in list.withIndex())
        println("Index = $index, Element = $elem")

    // for with map
    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    for ((key, value) in map)
        println("Key = $key, Val = $value")

    // for with range (upper bound inclusive)
    for (i in 1..9)
        if (i % 2 == 0) println(i)

    // for with until (upper bound exclusive)
    for (i in 1 until 9)
        print(i)
    println()

    // for with range + step (up)
    for (i in 1..9 step 2)
        print(i)
    println()

    // for with step (down)
    for (i in 9 downTo 1 step 2)
        print(i)
    println()

    // iterating a string
    for (c in "test")
        print(c + 1)
    println()
}