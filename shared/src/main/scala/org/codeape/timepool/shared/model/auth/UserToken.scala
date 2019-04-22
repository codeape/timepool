package org.codeape.timepool.shared.model.auth

import com.avsystem.commons.serialization.HasGenCodec

/** User identification token. Passed with the RPC requests. */
case class UserToken(
  id: String,
  org: String,
  created: String,
  permission: Permission,
  sig: String
)
object UserToken extends HasGenCodec[UserToken]

