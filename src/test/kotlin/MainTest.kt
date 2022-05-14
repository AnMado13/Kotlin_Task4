import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.Test
import org.junit.BeforeClass
import org.junit.Assert.*

import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainTest {

    //changing the output stream from the console to the String
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
        bytesOutput.flush()
    }

    @After
    fun cleanupTest() {
        bytesOutput.flush()
    }

    @Test
    fun testZeroFactorial() {
        main("0")
        var actual = bytesOutput.toString(Charsets.UTF_8).trim()

        assertEquals("Fractal of zero is wrong", 1, actual.toInt())
    }


}
