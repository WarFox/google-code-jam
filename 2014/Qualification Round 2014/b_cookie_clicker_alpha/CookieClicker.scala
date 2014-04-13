import scala.io.Source;
import java.text.DecimalFormat;

object CookieClicker extends App {

  def solve(r: BigDecimal, c: BigDecimal, f: BigDecimal, x: BigDecimal): BigDecimal = {

      var rate = r
      var farmCount = 0

      var totalTime = new BigDecimal(new java.math.BigDecimal(0))
      var timeToReachx = x/rate
      var previousCalc = timeToReachx

      while(true) {
        totalTime += c/rate
        farmCount+=1
        rate+=f
        timeToReachx = totalTime + (x/rate)
        if(previousCalc < timeToReachx)
          return previousCalc
        previousCalc = timeToReachx
      }

      return timeToReachx
  }

  def solve(c: String, f: String, x: String): BigDecimal = {

    val r = new BigDecimal(new java.math.BigDecimal(2))
    solve(r, new java.math.BigDecimal(c), new java.math.BigDecimal(f), new java.math.BigDecimal(x))
  }

  def solve(input: String): BigDecimal = {
    val inputArray = input.split(" ")

    solve(inputArray(0), inputArray(1), inputArray(2))
  }

  override def main(args: Array[String]): Unit = {
    var fileName = args(0)

    val input = Source.fromFile(fileName).getLines()
    val output = new java.io.PrintWriter("output.txt")

    val testCount = input.next.toInt

    val formatter = new DecimalFormat("#.0000000")

    for (testCase <- 1 to testCount) {
      val result = solve(input.next)
      var formatted = formatter format result

      println(s"Case #$testCase: $formatted")
      output.println(s"Case #$testCase: $formatted")
    }

    output.close
  }

}
