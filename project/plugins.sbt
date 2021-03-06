libraryDependencies += "org.scala-js" %% "scalajs-env-selenium" % "0.3.0"

// Scala-js
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "0.6.0")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.26")

// Packaging
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.19")