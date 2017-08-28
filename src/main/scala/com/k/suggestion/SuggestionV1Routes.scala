package com.k.suggestion

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.directives.MethodDirectives.get
import akka.http.scaladsl.server.directives.PathDirectives.path
import akka.http.scaladsl.server.directives.RouteDirectives.complete

trait SuggestionV1Routes extends JsonSupport {
  implicit def system: ActorSystem

  lazy val log = Logging(system, classOf[SuggestionV1Routes])

  lazy val routes: Route =
    pathPrefix("v1") {
      pathEnd {
        concat(
          get {
            val d = List("SELECT", "INSERT", "UPDATE", "DELETE").map(w => Suggestion(w, w, 1, "DML"))
            complete(
              d
            )
          }
        )
      } ~
        pathPrefix("tables") {
          concat(
            (pathEnd & get) {
              complete(
                List("FROM a1", "FROM a2").map(w => Suggestion(w, w, 1, "TABLE"))
              )
            },
            (path(Remaining) & get) { tableName =>
              complete(
                List("column1", "column2", "column3", "column4").map(w => Suggestion(w, w, 1, "ATTRIBUTES"))
              )
            }
          )
        }
    }
}
