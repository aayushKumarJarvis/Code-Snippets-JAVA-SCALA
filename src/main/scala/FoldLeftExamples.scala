
class FoldLeftExamples {

  // code to perform the sum of elements in a list
  def sum(list: List[Int]): Int = list.foldLeft(0)((r,c) => r+c)

  
}
