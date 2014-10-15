
class QuickSort {
  
  def quickSort(listToBeSorted: List[Int]): List[Int] =
    if (listToBeSorted.isEmpty) {
      listToBeSorted
    }
    else {
      val (smaller, bigger) = listToBeSorted.tail partition (_ < listToBeSorted.head)
      quickSort(smaller) ::: listToBeSorted.head :: quickSort(bigger)
    }
}
