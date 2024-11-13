package fix

import org.scalatest.funsuite.AnyFunSuiteLike
import scalafix.testkit._

class RuleSuite extends AbstractSemanticRuleSuite with AnyFunSuiteLike {
  runAllTests()
}
