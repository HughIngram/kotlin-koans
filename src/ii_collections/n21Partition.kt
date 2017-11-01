package ii_collections

fun example8() {
    val numbers = listOf(1, 3, -4, 2, -11)

    // The details (how multi-assignment works) will be explained later in the 'Conventions' task
    val (positive, negative) = numbers.partition { it > 0 }

    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)
}

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
// Return customers who have more undelivered orders than delivered
    return customers.partition {
        it.orders.filter { it.isDelivered }.size < it.orders.filter { !it.isDelivered }.size
    }.first.toSet()
}

// solution by shivan42 -
/*
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    // Return customers who have more undelivered orders than delivered
    return this.customers.filter {
        val (delivered, undelivered) = it.orders.partition { it.isDelivered }
        undelivered.count() > delivered.count()
    }.toHashSet()
}
*/
// solution using filter only:
/*
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    return customers.filter {
        it.orders.filter { it.isDelivered }.size < it.orders.filter { !it.isDelivered }.size
    }.toSet()
}
*/
