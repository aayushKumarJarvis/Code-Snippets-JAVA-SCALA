
import scala.math

class EuclideanNorm {

  def calculateEuclideanNorm(listofIntegers: List[Int]):Int = {

    val squaredElements = listofIntegers.map(x => x*x).sum
    math.sqrt(squaredElements).toInt
  }
}
