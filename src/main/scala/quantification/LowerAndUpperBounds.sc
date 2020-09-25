
trait Thing
trait Vehicle extends Thing
class Car extends Vehicle
class Jeep extends Car
class MotorCycle extends Vehicle
class Vegetable extends Thing

class Parking[A >: Jeep <: Vehicle](place: A)
new Parking[Car](new Jeep())
//new Parking[Car](new MotorCycle()) fails

// Upper Bound
class Things[A >: Thing](thing: A)
new Things(new Car())
new Things(new Vegetable())

// Lower Bound
class Vehicles[A <: Vehicle](vehicle: A)
new Vehicles(new Car())
new Vehicles(new MotorCycle())

class Tools
class Hammer extends Tools

trait Box[A]

def foo(p: Box[Tools]): Box[Tools] = identity(p)
foo(new Box[Tools] {})
//foo1(new Box[Hammer] {}) fails

trait Box1[+A]
def foo1(p: Box1[Tools]): Box1[Tools] = identity(p)
foo1(new Box1[Tools] {})
foo1(new Box1[Hammer] {})


trait Box2[-A]
def foo2(p: Box2[Tools]): Box2[Tools] = identity(p)
foo2(new Box2[Tools] {})
//foo2(new Box2[Hammer] {}) fails
def foo22(p: Box2[Hammer]): Box2[Hammer] = identity(p)
foo22(new Box2[Hammer] {})
foo22(new Box2[Tools] {})

object TypeSpecification {
  trait Animal
  case class Cat() extends Animal
  case class Zoo[Cat: Animal]()

}

