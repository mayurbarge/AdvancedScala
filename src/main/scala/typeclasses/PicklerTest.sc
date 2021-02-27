object PicklerTest {
  trait Pickler[T] {
    def pickle(obj: T):String
  }
  implicit object intPickler extends Pickler[Int] {
    override def pickle(obj: Int): String = "~~~IntPickler"
  }

  def persist[T](obj: T)(implicit pickler: Pickler[T]) = {
    implicitly[Pickler[T]].pickle(obj)
  }
  def persist2[T:Pickler](obj: T) = {
    implicitly[Pickler[T]].pickle(obj)
  }
}
PicklerTest.persist(1)
