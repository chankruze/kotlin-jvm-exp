//import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import kotlin.reflect.typeOf

enum class Gender { MALE, FEMALE }

fun sum(x: Int, y: Int): Int = x * y

fun printPattern(char: Char = '*', number: Int = 5) {
    repeat(number) {
        print(char)
    }
    println()
}

fun String?.isEmptyOrNull() = this == null || this.isEmpty()

fun main() {
    val x = 1
    val y = 2
    println("x + y = ${sum(x, y)}")
    printPattern(number = 7)
    println("".isEmptyOrNull())

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


    // in (1. iteration, 2. check for belonging)
    // for (x in 1..9) {...}
    // c in 'a'..'z'

    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

    println(isLetter('*'))
    println(isLetter('1'))
    println(isLetter('K'))

    fun reconChar(c: Char) = when (c) {
        in '0'..'9' -> "It's a digit!"
        in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
        else -> "It's a special character!"
    }

    println(reconChar('#'))
    println(reconChar('9'))
    println(reconChar('K'))

    // in with range of strings
    println("Kotlin" in "Java".."Scala")
    println("Kotlin" in setOf("Java", "Scala"))

    println("ball" in "a".."k")
    println("kall" in "a".."k")
    println("lall" in "a".."k")

    //fun isValidIdentifier(s: String): Boolean {
//    fun isValidChar(c: Char): Boolean = when (c) {
//        '_' -> true
//        in '0'..'9' -> true
//        in 'a'..'z', in 'A'..'Z' -> true
//        else -> false
//    }
//
//    if (s.isEmpty() || s[0] in '0'..'9') return false
//
//    for (c in s)
//        if (!isValidChar(c)) return false
//
//    return true
//}

    // more kotlinish way
    fun isValidIdentifier(s: String): Boolean {
        fun isValidChar(ch: Char): Boolean = ch == '_' || ch.isLetterOrDigit()

        if (s.isEmpty() || s[0].isDigit()) return false

        for (c in s)
            if (!isValidChar(c)) return false

        return true
    }

    println("*** Task 1 ***")
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false

    // Exceptions
    // throw & try are expressions means we can assing to variables
//    val number = 134
//    val percent =
//            if (number in 0..100)
//                number
//            else
//                throw IllegalArgumentException("A percentage value must be between 0 and 100: $number")
//
//    println(percent)

    val string = "*"
    val num = try {
        Integer.parseInt(string)
    } catch (e: NumberFormatException) {
        null
    }

    println("num = $num")

    // extension function (static)
    // fun String.lastChar () = this.get(this.length - 1)
    // here String is the receiver
    fun String.lastChar() = get(length - 1)

    println("SwAyaMOP".lastChar())

    // kotlin std lib = java lib + kotlin extension
    // examples

    val set2 = hashSetOf(1, 7, 53)
    val list2 = arrayListOf(1, 7, 53)
    val map2 = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set2)
    println(list2)
    println(map2)

    println(set2.javaClass)
    println(list2.javaClass)
    println(map2.javaClass)

    println(listOf('a', 'b', 'c').joinToString(
            separator = "",
            prefix = "(",
            postfix = ")"
    ))

    println(list2.getOrNull(0))
    println(list2.getOrNull(100))

    // extensions for Strings
    // multiline string with default margin prefix
    val str = """To code,
        |or not to code ?..""".trimMargin()

    println(str)
    println()

    // custom margin prefix
    val str2 = """To code,
        #or not to code ?..
            #Whatever!""".trimMargin(marginPrefix = "#")

    println(str2)

    val str3 = """
        Trimmigngg
        dgdgdgd
        gdg
        dgd
    """.trimIndent()

    println(str3)

    val regex = """\d{2}\.\d{2}\.\d{4}""".toRegex()
    println(regex.matches("02.10.2020"))
    println(regex.matches("2.10.2020"))
    println(regex.matches("02.10.20"))

    println("123".toInt())
    println("1e-10".toDouble())
    println("xx".toIntOrNull())

    // Task 2 [Change the 'sum' function so that it was declared as an extension to List<Int>.]
    fun List<Int>.sum(): Int {
        var result = 0
        for (i in this) {
            result += i
        }
        return result
    }

    val sum = listOf(1, 2, 3).sum()
    println("sum = $sum")    // 6


    // collections
    data class Hero(val name: String, val age: Int, val gender: Gender?)

    val heroes = listOf(
            Hero("The Captain", 60, Gender.MALE),
            Hero("Frenchy", 42, Gender.MALE),
            Hero("The Kid", 9, null),
            Hero("Lady Lauren", 29, Gender.FEMALE),
            Hero("First Mate", 29, Gender.MALE),
            Hero("Sir Stephen", 37, Gender.MALE))

    // last extension
    println(heroes.last().name)
    // first or null
    println(heroes.firstOrNull { it.age == 30 }?.name)
    // map & distinct
    println(heroes.map { it.age }.distinct().size)
    // filter
    println(heroes.filter { it.age < 30 }.size)

    // partition
    val (younger, older) = heroes.partition { it.age < 30 }
    println(older.size)

    // max by
    println(heroes.maxBy { it.age }?.name)

    // predicate
    println(heroes.all { it.age < 50 })
    println(heroes.any { it.gender == Gender.FEMALE })

    // groupBy
    val mapByAge: Map<Int, List<Hero>> = heroes.groupBy { it.age }
    val (age, group) =
            mapByAge.maxBy { (_, group) -> group.size }!!
    println(age)

    // associateBy
    val mapByName: Map<String, Hero> = heroes.associateBy { it.name }
    println(mapByName["Frenchy"]?.age)

    // getOrElse
    val mapByName2 = heroes.associateBy { it.name }
    val unknownHero = Hero("Unknown", 0, null)
    println(mapByName2.getOrElse("unknown") { unknownHero }.age)

    // bad code
    val (first, second) = heroes
            .flatMap { heroes.map { hero -> it to hero } }
            .maxBy { it.first.age - it.second.age }!!
    println(first.name)

    // above shit bad code equals
    println(heroes.maxBy { it.age }?.name)

    val isEven = { i: Int -> i % 2 == 0 }
    println(isEven(45))
}
