import java.math.BigInteger

fun main(number: Int){

    var factorial = BigInteger("1")

    for (multiplier in 2..number){
        factorial *= multiplier.toBigInteger()
    }

    print(factorial)
}