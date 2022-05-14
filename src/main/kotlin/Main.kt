import java.math.BigInteger

fun main(arg: String){

    val number = arg.toInt()
    var factorial = BigInteger("1")

    for (multiplier in 2..number){
        factorial *= multiplier.toBigInteger()
    }

    println(factorial)
}