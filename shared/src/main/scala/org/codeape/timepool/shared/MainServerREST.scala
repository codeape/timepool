package org.codeape.timepool.shared

import com.twitter.util.Future
//import io.udash.rest._
import org.codeape.timepool.shared.model.auth.UserContext
import org.codeape.timepool.shared.twitter.TwitterRestApiCompanion

trait AuthREST {

  def login(username: String, password: String): Future[UserContext]

}
object AuthREST extends TwitterRestApiCompanion[AuthREST]

trait MainServerREST {

  /** Authentication. */
  def auth(): AuthREST

}
object MainServerREST extends TwitterRestApiCompanion[MainServerREST]
