
class MergeSort {

  def mergeLists(xs: List[Int], ys: List[Int], res: List[Int]): List[Int] =
    (xs, ys) match {
      case (Nil, ys) => res.reverse ++ ys
      case (xs, Nil) => res.reverse ++ xs
      case (x :: xs1, y :: ys1) =>
        if (x < y) mergeLists(xs1, ys, x :: res)
        else mergeLists(xs, ys1, y :: res)
    }

  def apply(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0)
      xs
    else {
      val (left, right) = xs splitAt (n)
      mergeLists(apply(left), apply(right), Nil)
    }
  }
}
