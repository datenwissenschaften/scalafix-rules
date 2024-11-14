/*
rule = SingleLineNestedExpressions
 */
// format: off
package fix

case class Person(name: String, age: Int, address: Address)
case class Address(street: String, city: String, country: String)

object SingleLineNestedExpressions {

  val example1 = Some(
    Right(
      "This is a test"
    )
  )

  val example2 = Map(
    "key1" -> List(1, 2, 3),
    "key2" -> List(4, 5, 6)
  )

  val example3 = Person(
    name = "Alice",
    age = 30,
    address = Address("123 Main St", "City", "Country")
  )

}
// format: on
