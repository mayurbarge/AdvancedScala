package quantification
/*
Train Tickets are of following Quotas
General
SeniorCitizen - 30%
WomenSpecial - 50% with resevation
Handicapped - Free

Ticket
CGST 6%
SGST 6%

Print all tickets
There is one WomanSpecial
Train
 */
case class Amount(value: Double)
trait Discount {
  val rule: (Amount => Amount)
}
case object Discount {
  val SeniorCitizenDiscount = new Discount { override val rule: Amount => Amount = (amount: Amount) => Amount(amount.value * (30 / 100))}
  val WomenSpecialDiscount = new Discount { override val rule: Amount => Amount = (amount: Amount) => Amount(amount.value * (50 / 100))}
  val HandicappedDiscount = new Discount { override val rule: Amount => Amount = (_: Amount) => Amount(0) }
}

trait Pricing {
  val rule: (Ticket => Amount)
}
trait Ticket
case class WomenSpecialTicket() extends Ticket
case class HandicappedTicket() extends Ticket

case class PrintQueue[+T](elements: scala.collection.immutable.List[T]) {
  def enqueue[U >: T](ticket: U) = PrintQueue[U](ticket :: elements)
  def get[V >: T]: List[V] = elements
}
