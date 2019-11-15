import java.math.BigDecimal
import java.time.DayOfWeek
import java.time.LocalDateTime

class OrdersAnalyzer {

    data class Order(val orderId: Int, val creationDate: LocalDateTime, val orderLines: List<OrderLine>)
    data class Product(val productId: Int, val name: String,val unitPrice: BigDecimal)
    data class OrderLine(val prod:Product, val quantity: Int)



    fun totalQuantityOrder(orderLines: List<OrderLine>):Int{
        var quant = 0
        for (line in orderLines)
        {

            quant += line.quantity

        }
        return quant
    }

    fun totalDailySales(orders: List<Order>): Map<DayOfWeek, Int> {
        var mapQuant = mutableMapOf<DayOfWeek, Int>()
        for (ord in orders)
        {

            var totalOrdQuant = totalQuantityOrder((ord.orderLines))

            val dayOfW = ord.creationDate.dayOfWeek
            if (mapQuant.containsKey(dayOfW)) {
                totalOrdQuant += mapQuant[dayOfW]!!

                mapQuant[dayOfW]= totalOrdQuant

            }
                else
                {
                    mapQuant[dayOfW] = totalOrdQuant
                }

        }
        return mapQuant
    }

    fun printMapDays(mapDays:Map<DayOfWeek, Int>){
        for ((day,total) in mapDays)
        {
            println(day.toString() + ":  "+ total)
        }

    }

}