package iii_conventions

import iv_properties.toMillis
import util.TODO
import util.doc25

fun todoTask25(): Nothing = TODO(
    """
        Task 25.
        Uncomment the commented line and make it compile. 
        Add all changes to the file MyDate.kt.
        Make class MyDate implement Comparable.
    """,
    documentation = doc25(),
    references = { date: MyDate, comparable: Comparable<MyDate> -> }
)

operator fun MyDate.compareTo(other: MyDate): Int {
    val thisTime = this.toMillis()
    val anotherTime = other.toMillis()
    return if (thisTime < anotherTime) -1 else if (thisTime == anotherTime) 0 else 1
}

fun task25(date1: MyDate, date2: MyDate): Boolean {
    return date1 < date2
}

