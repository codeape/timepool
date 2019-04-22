package org.codeape.timepool.shared.twitter

import com.twitter.util.{Future, Promise, Return, Throw}
import io.udash.rest.{GenCodecRestImplicits, OpenApiFullInstances, RestOpenApiCompanion}
import io.udash.rest.raw.RawRest.{Async, AsyncEffect}
import com.avsystem.commons._
import com.avsystem.commons.meta.MacroInstances
import com.avsystem.commons.misc.ImplicitNotFound
import io.udash.rest.raw.HttpResponseType

import scala.annotation.implicitNotFound

trait TwitterRestImplicits extends GenCodecRestImplicits {

  implicit def futureToAsyn(): AsyncEffect[Future] = new AsyncEffect[Future] {
    def toAsync[A](future: Future[A]): Async[A] =
      callback => future.respond {
        case Return(value) => callback(Success(value))
        case Throw(exception) => callback(Failure(exception))
      }
    def fromAsync[A](async: Async[A]): Future[A] = {
      val future = Promise[A]()
      async {
        case Success(value) => future.setValue(value)
        case Failure(exception) => future.setException(exception)
      }
      future
    }
  }

  @implicitNotFound("${T} is not a valid HTTP method result type - it must be wrapped into a twitter Future")
  implicit def httpResponseTypeNotFound[T]: ImplicitNotFound[HttpResponseType[T]] =
    ImplicitNotFound()

}
object TwitterRestImplicits extends TwitterRestImplicits

abstract class TwitterRestApiCompanion[Real](
  implicit macroInstances: MacroInstances[TwitterRestImplicits, OpenApiFullInstances[Real]]
) extends RestOpenApiCompanion[TwitterRestImplicits, Real](TwitterRestImplicits)
