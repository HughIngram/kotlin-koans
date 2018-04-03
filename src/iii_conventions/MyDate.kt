package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override operator fun compareTo(other: MyDate): Int {
        if (this.year != other.year) return (this.year - other.year)
        if (this.month != other.month) return (this.month - other.month)
        return (this.dayOfMonth - other.dayOfMonth)
    }

    operator fun rangeTo(end: MyDate): DateRange = DateRange(this, end)

    operator fun inc(): MyDate = this.nextDay()

    operator fun plus(interval: TimeInterval): MyDate =
            addTimeIntervals(interval, 1)

    operator fun plus(interval: RepeatedTimeInterval): MyDate =
            addTimeIntervals(interval.ti, interval.n)

    operator fun times(repeatedInterval: RepeatedTimeInterval): MyDate =
            addTimeIntervals(repeatedInterval.ti, repeatedInterval.n)

}


enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    operator fun times(n: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, n)
}


class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {

    override operator fun contains(value: MyDate): Boolean = value >= start && value <= endInclusive

    override fun iterator(): Iterator<MyDate> = DateIterator(this)

    class DateIterator(private val dateRange: DateRange) : Iterator<MyDate> {

        private var cursor: MyDate = dateRange.start

        override fun hasNext(): Boolean = cursor <= dateRange.endInclusive

        override fun next(): MyDate = cursor++
    }

}
