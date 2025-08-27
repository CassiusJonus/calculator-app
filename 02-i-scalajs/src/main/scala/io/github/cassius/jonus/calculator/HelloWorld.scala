package example

import com.raquo.laminar.api.L.{*, given}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object HelloWorld {

  def apply(): HtmlElement = {
    val nameVar = Var(initial = "world")
    div(
      cls("HelloWorld"),
      label("Your name: "),
      input(
        onMountFocus,
        placeholder := "Enter your name here",
        onInput.mapToValue --> nameVar
      ),
      div(
        cls("-greeting"),
        "Hello, ",
        text <-- nameVar.signal.map(_.toUpperCase)
      )
    )
  }
}
