ThisBuild / organization := "io.github.cassius.jonus"
ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "3.3.6"

lazy val coreDeps = Seq(
  "org.typelevel" %% "cats-core" % "2.13.0",
  "org.typelevel" %% "cats-docs" % "2.13.0",
  "dev.zio" %% "zio" % "2.1.20"
)

lazy val parserDeps = Seq(
  "org.typelevel" %% "cats-parse" % "1.1.0"
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "calculator-app",
    scalacOptions ++= Seq("-encoding", "utf-8", "-deprecation", "-feature")
  )
  .aggregate(core, `core-impl`, parser, persistence, terminal, main)

lazy val core = project
  .in(file("01-core"))
  .settings(
    name := "core",
    libraryDependencies ++= coreDeps
  )

lazy val parser = project
  .in(file("02-c-parser-cats-parse"))
  .settings(
    name := "parser",
    libraryDependencies ++= parserDeps
  )
  .dependsOn(core)

lazy val persistence = project
  .in(file("02-o-persistence-file"))
  .dependsOn(core)
  .settings(
    name := "persistence"
  )

lazy val `core-impl` = project
  .in(file("02-o-core-impl"))
  .dependsOn(parser)
  .settings(
    name := "core-impl"
  )

lazy val terminal = project
  .in(file("02-i-delivery-terminal"))
  .dependsOn(core)
  .settings(
    name := "termainal"
  )

lazy val main = project
  .in(file("03-main"))
  .dependsOn(parser)
  .dependsOn(`core-impl`)
  .dependsOn(terminal)
  .settings(
    name := "main"
  )
