package ii_collections

fun example7() {
    val result = listOf("a", "b", "ba", "ccc", "ad").groupBy { it.length }
    println(result)
    result == mapOf(1 to listOf("a", "b"), 2 to listOf("ba", "ad"), 3 to listOf("ccc"))
}

// map of cities->list of customers
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> {
    // Return a map of the customers living in each city
    return customers.groupBy({ it.city })
}
