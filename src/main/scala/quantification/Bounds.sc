// Lower Bounds
// U >: T means T is a lowerbound for U
trait Fruit {
  def weight: Double
}
case class Orange(weight: Double) extends Fruit
case class Apple(weight: Double) extends Fruit

class Queue[+T](private val leading: List[T], private val trailing: List[T]) {
  def enqueue[U >: T](x: U): Queue[U] = {
    new Queue[U](leading, x :: trailing)
  }

  override def toString: String = {
    leading.map(_.toString).toString() + trailing.map(_.toString).toString()
  }
}


val orangeQueue = new Queue[Orange](List(Orange(22.3)), List.empty)
val appleQueue = new Queue[Apple](List(Apple(30.2)), List.empty)
val fruitQueue = orangeQueue.enqueue(Apple(20.0))

//context bounds
//def g[A : B](a: A) = h(a)
//def g[A](a: A)(implicit ev: B[A]) = h(a) ------desugared