import scala.io.Source

object MagicTrick extends App {

  def read(input: Iterator[String]) = {
    val cards = Array.ofDim[Int](4, 4)

    for (i <- 0 to 3) {
      val input_next = input.next
      val line = input_next.split(" ")
      for (j <- 0 to 3) {
        cards(i)(j) = line(j).toInt
      }
    }
    cards
  }

   def solve(choice1: Int, cards1: Array[Array[Int]], choice2: Int, cards2: Array[Array[Int]]): String = {
      var result = "Bad magician!"

      val one = cards1(choice1-1)
      val two = cards2(choice2-1)
      val common = one intersect two

      if(common.length == 1) result = common(0).toString
      else {
        if(common.length == 0) {
          result = "Volunteer cheated!"
        }
      }

      result
   }

  override def main(args: Array[String]): Unit = {
    var fileName = args(0)

    val input = Source.fromFile(fileName).getLines()
    val output = new java.io.PrintWriter("output.txt")

    val testCount = input.next.toInt

    for (testCase <- 1 to testCount) {
      val choice1 = input.next.toInt
      val cards1 = read(input)
      val choice2 = input.next.toInt
      val cards2 = read(input)
      val result = solve(choice1, cards1, choice2, cards2);
      output.println(s"Case #$testCase: $result")
    }

    output.close()
  }

}
