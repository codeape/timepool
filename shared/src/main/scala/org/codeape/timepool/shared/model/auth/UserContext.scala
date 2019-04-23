package org.codeape.timepool.shared.model.auth

import io.udash.auth.{Permission => UdashPermission, UserCtx => UdashUserCtx}
import io.udash.rest.RestDataCompanion

/** User data container. */
case class UserContext(token: UserToken) extends UdashUserCtx {
  override def has(permission: UdashPermission): Boolean = permission == permission
  override def isAuthenticated: Boolean = true
}
object UserContext extends RestDataCompanion[UserContext]
