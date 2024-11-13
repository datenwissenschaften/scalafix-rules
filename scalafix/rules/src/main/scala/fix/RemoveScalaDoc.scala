package fix

import scalafix.util.Newline
import scalafix.v1._

import scala.meta._
import scala.meta.tokens.Token.{Comment, Whitespace}

class RemoveScalaDoc extends SemanticRule("RemoveScalaDoc") {

  override def fix(implicit doc: SemanticDocument): Patch =
    // Collect all tokens and remove ScalaDoc comments and the following whitespace/newline tokens
    doc.tokens.collect {
      case token if token.isInstanceOf[Comment] && token.syntax.startsWith("/**") =>
        // Remove the ScalaDoc comment itself
        val removeCommentPatch = Patch.removeToken(token)

        // Remove any following whitespace or newlines that are tied to the comment block
        val removeFollowingWhitespacePatch = {
          val index = doc.tokens.indexOf(token)
          var patches = Patch.empty

          // Loop through subsequent tokens and remove whitespace or newlines
          if (index < doc.tokens.length - 1) {
            var nextIndex = index + 1
            while (
              nextIndex < doc.tokens.length &&
              (doc.tokens(nextIndex).is[Whitespace] || doc.tokens(nextIndex).is[Newline])
            ) {
              patches += Patch.removeToken(doc.tokens(nextIndex))
              nextIndex += 1
            }
          }

          patches
        }

        // Combine the patches
        removeCommentPatch + removeFollowingWhitespacePatch
    }.asPatch
}
