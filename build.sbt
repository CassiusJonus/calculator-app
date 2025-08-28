import org.scalajs.linker.interface.ModuleSplitStyle

ThisBuild / organization := "io.github.cassius.jonus"
ThisBuild / name := "Calculator App"
ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "3.3.6"

lazy val coreDeps = Seq(
  "org.typelevel" %% "cats-core" % "2.13.0",
  "org.typelevel" %% "cats-docs" % "2.13.0"
)

lazy val parserDeps = Seq(
  "org.typelevel" %% "cats-parse" % "1.1.0"
)

lazy val root = project
  .in(file("."))
  .settings(
    scalacOptions ++= Seq("-encoding", "utf-8", "-deprecation", "-feature")
  )
  .aggregate(core, `core-impl`, parser, terminal, main)

lazy val core = project
  .in(file("-01-core"))
  .settings(
    libraryDependencies ++= coreDeps
  )

lazy val parser = project
  .in(file("02-c-parser-cats-parse"))
  .settings(
    libraryDependencies ++= parserDeps
  )
  .dependsOn(core)

lazy val `core-impl` = project
  .in(file("02-o-core-impl"))
  .dependsOn(parser)

lazy val terminal = project
  .in(file("02-i-delivery-terminal"))
  .dependsOn(core)

lazy val main = project
  .in(file("03-main"))
  .dependsOn(parser)
  .dependsOn(`core-impl`)
  .dependsOn(terminal)
