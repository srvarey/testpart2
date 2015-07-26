
object Test2 {


  def unitTests: Unit = {
    assert(leftTruncate(0) == List (0))
    assert(leftTruncate(1) == List (1))
    assert(leftTruncate(12) == List (12, 2))
    assert(leftTruncate(123) == List (123, 23, 3))
    assert(leftTruncate(1234) == List (1234, 234, 34, 4))
    assert(leftTruncate(12345) == List (12345, 2345, 345, 45, 5))
  }
  def main (args : Array[String]): Unit = {

    unitTests

  }


  def leftTruncateHelperTailRec(p: List[List[Int]], v: List[Int]): List[String] = {

    if (v == Nil)
      p.map(_.mkString)
    else
      leftTruncateHelperTailRec(p :+ v, v.tail)
  }

  def leftTruncateHelper(nlist: List[Int]): List[String] = {
    leftTruncateHelperTailRec(List(nlist), nlist.tail)
  }


  def leftTruncate(num: Int): List[Int] = {
    val v = leftTruncateHelper(num.toString.map(_.asDigit).toList).map(_.toInt)
    println(v)
    v
  }
}
