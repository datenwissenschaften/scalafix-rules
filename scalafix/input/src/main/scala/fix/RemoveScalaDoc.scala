/*
rule = RemoveScalaDoc
 */
package fix

/** object scala doc
  */
object RemoveScalaDoc {

  /** This is the scala doc */
  def myMethodWithScaladoc(): Unit = {
    // This is a comment
    println("Hello, world!")
  }

  /** This is the scala doc
    * multiline
    */
  def myMethodWithScaladocMultiline(): Unit = {
    // This is a comment
    println("Hello, world!")
  }

}
