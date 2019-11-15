import java.math.BigDecimal
import java.time.LocalDateTime

fun main() {
    println("Hello World!")
    var orderList = mutableListOf<OrdersAnalyzer.Order>()
    val pencil = OrdersAnalyzer.Product(9872, "Pencil", BigDecimal("3.12"))
    val pen = OrdersAnalyzer.Product(5723, "Pen", BigDecimal("4.22"))
    val eraser = OrdersAnalyzer.Product(1746, "Eraser", BigDecimal("1.00"))
    val eraser_set = OrdersAnalyzer.Product(3433, "Eraser Set", BigDecimal("6.15"))
    val marker = OrdersAnalyzer.Product(4098, "Marker", BigDecimal("4.50"))

    var orderbuff = OrdersAnalyzer.Order(
        554,
        LocalDateTime.parse("2017-03-25T10:35:20"), //saturday
        listOf(OrdersAnalyzer.OrderLine(pencil, 3)))
    orderList.add(orderbuff)
    orderbuff = OrdersAnalyzer.Order(
        555,
        LocalDateTime.parse("2017-03-25T11:24:20"),
        listOf(OrdersAnalyzer.OrderLine(pencil, 2),
            OrdersAnalyzer.OrderLine(eraser, 1)))
    orderList.add(orderbuff)
    orderbuff = OrdersAnalyzer.Order(
        453,
        LocalDateTime.parse("2017-03-27T14:53:12"),
        listOf(OrdersAnalyzer.OrderLine(pen, 4),
                OrdersAnalyzer.OrderLine(pencil, 3),
                OrdersAnalyzer.OrderLine(eraser_set, 1)))
    orderList.add(orderbuff)
    orderbuff = OrdersAnalyzer.Order(
        431,
        LocalDateTime.parse("2017-03-20T12:15:02"),
        listOf(OrdersAnalyzer.OrderLine(pen, 7),
               OrdersAnalyzer.OrderLine(eraser_set, 2)))
    orderList.add(orderbuff)
    orderbuff = OrdersAnalyzer.Order(
        690,
        LocalDateTime.parse("2017-03-26T11:14:00"),
        listOf(OrdersAnalyzer.OrderLine(pencil, 4),
            OrdersAnalyzer.OrderLine(marker, 5)))
    orderList.add(orderbuff)
    val ordersTotal = OrdersAnalyzer()
    val mapDays = ordersTotal.totalDailySales(orderList)
    ordersTotal.printMapDays(mapDays)


}