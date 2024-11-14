// src/main/scala/fix/SingleLineNestedExpressions.scala
package fix

import scalafix.v1._

import scala.annotation.tailrec
import scala.meta._

class SingleLineNestedExpressions extends SyntacticRule("SingleLineNestedExpressions") {
  override def fix(implicit doc: SyntacticDocument): Patch =
    // Collect and apply patches for top-level multiline `Term.Apply` instances
    doc.tree.collect {
      case t: Term.Apply if isMultiLine(t) && isTopLevel(t) =>
        // Construct the top-level expression in a single line
        val singleLineExpr = buildSingleLineExpression(t)

        // Replace only the top-level `Term.Apply` text with the single-line expression
        Patch.replaceTree(t, singleLineExpr)
    }.asPatch

  // Helper function to construct the single-line format from a `Term.Apply`
  private def buildSingleLineExpression(term: Term.Apply): String = {
    val functionPart = term.fun.syntax
    val singleLineArgs = term.args.map(_.syntax).mkString(", ")
    s"$functionPart($singleLineArgs)"
  }

  // Helper function to check if the term spans multiple lines
  private def isMultiLine(term: Term.Apply): Boolean = term.pos.endLine > term.pos.startLine

  // Helper function to ensure only top-level `Term.Apply` instances are processed
  private def isTopLevel(term: Term.Apply): Boolean = {
    @tailrec
    def hasApplyAncestor(tree: Tree): Boolean = tree.parent match {
      case Some(_: Term.Apply) => true // Found a parent `Term.Apply`, so this is not top-level
      case Some(parent) => hasApplyAncestor(parent) // Continue up the tree
      case None => false // Reached the top without finding an ancestor `Term.Apply`
    }
    !hasApplyAncestor(term)
  }
}
