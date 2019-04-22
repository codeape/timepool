package org.codeape.timepool.shared.model.auth

import com.avsystem.commons.serialization.HasGenCodec
import io.udash.auth.{Permission => UdashPermission, UserCtx => UdashUserCtx}

/** User data container. */
case class UserContext(token: UserToken) extends UdashUserCtx {
  override def has(permission: UdashPermission): Boolean = permission == permission
  override def isAuthenticated: Boolean = true
}
object UserContext extends HasGenCodec[UserContext]
