import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.Test
import org.junit.BeforeClass
import org.junit.Assert.*
import java.io.ByteArrayOutputStream
import java.io.FileReader
import java.io.PrintStream

import java.math.BigInteger

class MainTest {

    companion object {

        private val console: PrintStream = System.out
        private var bytesOutput: ByteArrayOutputStream = ByteArrayOutputStream()
        private val printStreamNew: PrintStream = PrintStream(bytesOutput)

        @BeforeClass
        @JvmStatic
        fun setUp(){
            System.setOut(printStreamNew)
        }

        @AfterClass
        @JvmStatic
        fun tearDown(){
            System.setOut(console)
        }

    }

    @Before
    fun prepareTest() {
        bytesOutput.reset()
    }

    @After
    fun cleanupTest() {
        bytesOutput.reset()
    }

    @Test
    fun testFactorialOfZero() {
        main("0")
        val actual = bytesOutput.toString(Charsets.UTF_8).toInt()

        assertEquals("Factorial of zero is wrong", 1, actual)
    }

    @Test
    fun testFactorialOfOne(){
        main("1")
        val actual = bytesOutput.toString(Charsets.UTF_8).toInt()

        assertEquals("Factorial of one is wrong", 1, actual)
    }

    @Test
    fun testNotBigEvenFactorial(){
        main("6")
        val actual = bytesOutput.toString(Charsets.UTF_8).toInt()

        assertEquals("Factorial of small even number is wrong", 720, actual)
    }

    @Test
    fun testNotBigOddFactorial(){
        main("5")
        val actual = bytesOutput.toString(Charsets.UTF_8).toInt()

        assertEquals("Factorial of small odd number is wrong", 120, actual)
    }

    @Test
    fun testBigFactorial(){
        main("100")
        val actual = BigInteger(bytesOutput.toString(Charsets.UTF_8))


        val fileReader = FileReader("./src/test/answer/answer.txt")
        val expected = BigInteger(fileReader.readLines()[0])

        assertTrue("Factorial of big number is wrong", expected == actual)
    }


}
