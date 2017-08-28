package com.k.suggestion

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.ServerBinding
import akka.stream.ActorMaterializer

import scala.concurrent.{ ExecutionContext, Future }

object Main extends App with SuggestionV1Routes {
  import ch.megard.akka.http.cors.scaladsl.CorsDirectives._

  implicit val system: ActorSystem = ActorSystem("suggestionServer")
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  implicit val executionContext: ExecutionContext = system.dispatcher

  val corsRoutes = cors() { routes }
  val serverBindingFuture: Future[ServerBinding] = Http().bindAndHandle(corsRoutes, "0.0.0.0", 8080)

  println(s"Server online at http://0.0.0.0:8080")
}
