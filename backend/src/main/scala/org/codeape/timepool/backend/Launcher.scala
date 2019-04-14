package org.codeape.timepool.backend

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter

class Launcher extends HttpServer {

  override val defaultHttpPort: String = ":8080"

  override protected def configureHttp(router: HttpRouter): Unit = {

  }

}
