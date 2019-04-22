package org.codeape.timepool.shared.model.auth

import com.avsystem.commons.misc.{EnumCtx, ValueEnum, ValueEnumCompanion}
import io.udash.auth.{PermissionId, Permission => UdashPermission}

/** Class representing a user permission.
  *
  * Used with auth utilities from Udash.
  *
  */
sealed class Permission private(val id: PermissionId)(implicit val enumCtx: EnumCtx)
  extends UdashPermission with ValueEnum

object Permission extends ValueEnumCompanion[Permission] {
  final val Customer: Value = new Permission(PermissionId("customer"))
  final val User: Value = new Permission(PermissionId("user"))
  final val PowerUser: Value = new Permission(PermissionId("power"))
  final val Admin: Value = new Permission(PermissionId("admin"))
}

