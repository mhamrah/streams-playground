name := "streams-playground"

organization := "com.hamrah"

version := "0.1.0-SNAPSHOT"

homepage := Some(url("https://github.com/mhamrah/streams-playground"))

startYear := Some(2014)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/mhamrah/streams-playground"),
    "scm:git:https://github.com/mhamrah/streams-playground.git",
    Some("scm:git:git@github.com:mhamrah/streams-playground.git")
  )
)

/* scala versions and options */
scalaVersion := "2.11.4"

// These options will be used for *all* versions.
scalacOptions ++= Seq(
  "-deprecation"
  ,"-unchecked"
  ,"-encoding", "UTF-8"
  ,"-Xlint"
  ,"-Yclosure-elim"
  ,"-Yinline"
  ,"-Xverify"
  ,"-feature"
  ,"-language:postfixOps"
  //,"-optimise"
)

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

val akka = "2.3.8"

/* dependencies */
libraryDependencies ++= Seq (
  "com.github.nscala-time" %% "nscala-time" % "1.4.0"
  // -- testing --
  , "org.scalatest" %% "scalatest" % "2.2.2" % "test"
  // -- Logging --
  ,"ch.qos.logback" % "logback-classic" % "1.1.2"
  ,"com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
  // -- Akka --
  ,"com.typesafe.akka" %% "akka-testkit" % akka % "test"
  ,"com.typesafe.akka" %% "akka-actor" % akka
  ,"com.typesafe.akka" %% "akka-slf4j" % akka
  ,"com.typesafe.akka" %% "akka-http-experimental" % "1.0-M2"
  // -- json --
  ,"com.typesafe.play" %% "play-json" % "2.4.0-M2"
  // -- config --
  ,"com.typesafe" % "config" % "1.2.1"
  ,"io.scalac" %% "reactive-rabbit" % "0.2.2"
)

/* you may need these repos */
resolvers ++= Seq(
  // Resolver.sonatypeRepo("snapshots")
  // Resolver.typesafeRepo("releases")
  //"spray repo" at "http://repo.spray.io"
)

fork := true

testOptions in Test += Tests.Argument("-oDS")

packageArchetype.java_server

scalaSource in Compile := baseDirectory.value / "src"

scalaSource in Test := baseDirectory.value / "src"

excludeFilter in (Compile, unmanagedSources) := HiddenFileFilter || "*_test.scala"

excludeFilter in (Test, unmanagedSources) := HiddenFileFilter

resourceDirectory in Compile := baseDirectory.value / "resources"

resourceDirectory in Test := baseDirectory.value / "resources_test"
