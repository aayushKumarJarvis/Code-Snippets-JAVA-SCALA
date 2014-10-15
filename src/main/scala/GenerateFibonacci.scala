
class GenerateFibonacci {

  def generateNthFibonacciTerm(num: Int): Int = {
    if (num < 2)
      num
    else
      generateNthFibonacciTerm(num - 1) + generateNthFibonacciTerm(num - 2)
  }

  def generateFibonacciSequence(num: Int): String = {
    val rangeList = (0 to num-1).toList
    val fiboList = rangeList.map(x=>generateNthFibonacciTerm(x))

    fiboList.mkString(" ")
  }
}




