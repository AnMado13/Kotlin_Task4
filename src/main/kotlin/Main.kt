import java.io.FileReader
import java.math.BigInteger

fun main(args: Array<String>){

    val fileReader = FileReader("./input/Input.doc")
    val number = (fileReader.readLines()[0]).toInt()
    var factorial = BigInteger("1")

    for (multiplier in 2..number){
        factorial *= multiplier.toBigInteger()
    }

    println(factorial)
}