
class FoldLeftExamples {

  // code to perform the sum of elements in a list
  def sumOfElements(list: List[Int]): Int = list.foldLeft(0)((r,c) => r+c)
  def sumOfElements1(list: List[Int]): Int = list.foldLeft(0)(_+_)

  // code to perform product of elements in a list
  def product(list: List[Int]): Int = list.foldLeft(1)(_*_)

  // code to count the number of elements in the list
  def count(list: List[Int]): Int = list.foldLeft(0)((sum,_) => sum + 1)

  // code to perform average of numbers in a list
  def calculateAverage(list: List[Int]): Double =
    list.foldLeft(0.0)(_+_) / list.foldLeft(0)((sum,_) => sum + 1)

  
  
}
