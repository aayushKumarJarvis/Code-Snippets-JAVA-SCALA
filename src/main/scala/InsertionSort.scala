
class InsertionSort {
  
  def insertionSort(listToBeSorted: List[Int]): List[Int] = {
    listToBeSorted match {
      case List() => List()
      case x :: xs1 => insertNum(x, insertionSort(xs1))
    }
  }

  def insertNum(x: Int, xs: List[Int]): List[Int] = {
    xs match {
      case List() => List(x)
      case y :: ys => if (x <= y) x :: xs else y :: insertNum(x, ys)
    }
  }
}
