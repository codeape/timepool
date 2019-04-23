package org.codeape.timepool.shared.model.auth

import io.udash.rest.RestDataCompanion

/** User identification token. Passed with the RPC requests. */
case class UserToken(
  id: String,
  org: String,
  created: String,
  permission: Permission,
  sig: String
)
object UserToken extends RestDataCompanion[UserToken]

