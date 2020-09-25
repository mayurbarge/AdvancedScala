trait Person
class GrandParent() extends Person
class Parent() extends GrandParent
class Child() extends Person
class GrandChild() extends Child

class VariantBox[A]
class CoBox[+A]
class ContraBox[-A]

def foo1(p: VariantBox[Person]): VariantBox[Person] = identity(p)
def foo2(p: CoBox[Person]): CoBox[Person] = identity(p)
def foo3(p: ContraBox[Parent]): ContraBox[Parent] = identity(p)

foo2(new CoBox[Person])
foo2(new CoBox[Child])
foo2(new CoBox[GrandChild])
foo2(new CoBox[GrandParent])

foo3(new ContraBox[Person])
foo3(new ContraBox[Parent])
foo3(new ContraBox[GrandParent])
//foo3(new ContraBox[Child]) fails

foo1(new VariantBox[Person])
//foo1(new VariantBox[Child]) fails
trait Function1[-P, +R] {
  def apply(p: P):R
}