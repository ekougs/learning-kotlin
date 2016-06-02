package iii_conventions

import util.TODO
import util.doc28

fun iterateOverCollection(collection: Collection<Int>) {
    for (element in collection) {}
}

fun iterateOverString() {
    // You can iterate over anything that has an 'iterator' method, member or extension.
    for (c in "abcd") {}
    "abcd".iterator() //library extension method
}

fun iterateOverRange() {
    for (i in 1..10) {}
    for (c in 'a'..'z') {}
}

fun todoTask28(): Nothing = TODO(
    """
        Task 28.
        Uncomment the commented code and make it compile.
        Add all changes to the file MyDate.kt.
        Make the class DateRange implement Iterable<MyDate>.
        You can use object expression or declare an extra class to implement Iterator<MyDate>.
        Use the utility function 'MyDate.nextDay()'.
    """,
    documentation = doc28(),
    references = { date: MyDate -> DateRange(date, date.nextDay()) })

operator fun DateRange.iterator(): Iterator<MyDate> {
    return object : Iterator<MyDate> {
        var currentDate = start
        override fun hasNext(): Boolean {
            return currentDate <= endInclusive
        }

        override fun next(): MyDate {
            val currentDate = this.currentDate
            this.currentDate = currentDate.nextDay()
            return currentDate
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}
