package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return customers.filter { customer -> customer.orderedProducts.contains(product) }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return orders.filter { order -> order.isDelivered }
            .flatMap { order -> order.products }
            .maxBy { product -> product.price }
}

fun Order.occurrence(product: Product): Int {
    return products.count { currentProduct -> currentProduct == product }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    return customers.flatMap { customer -> customer.orders }
            .fold(0, {count, order -> count + order.occurrence(product)})
}
