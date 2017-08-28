import sbt._
import sbt.Keys._

lazy val akkaHttpVersion = "10.0.9"
lazy val akkaVersion    = "2.5.3"

lazy val root = (project in file(".")).
  enablePlugins(JavaAppPackaging).
  settings(
    inThisBuild(List(
      organization    := "com.k",
      scalaVersion    := "2.12.3"
    )),
    name := "SQL Autocomoplete Server",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml"        % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream"          % akkaVersion,

      "com.typesafe.play" %% "play-json" % "2.6.3",
      "de.heikoseeberger" %% "akka-http-play-json" % "1.18.0",
      "ch.megard" %% "akka-http-cors" % "0.2.1",

      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
      "org.scalatest"     %% "scalatest"         % "3.0.1"         % Test

    )
  )

