
class Factorial {

 def computeFactorial(num : Int):String = {

    (2 to num).foldLeft(BigInt(1))(_*_).toString()
  }
}
