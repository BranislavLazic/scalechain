name := """scalechain"""

ThisBuild / version := "0.7"

ThisBuild / scalaVersion := "2.13.6"

lazy val `scalechain-api` =
  project
    .in(file("./scalechain-api"))
    .dependsOn(`scalechain-util`, `scalechain-net`, `scalechain-transaction`, `scalechain-wallet`)

lazy val `scalechain-chain` =
  project
    .in(file("./scalechain-chain"))
    .dependsOn(`scalechain-util`, `scalechain-storage`, `scalechain-transaction`)

lazy val `scalechain-cli` =
  project
    .in(file("./scalechain-cli"))
    .dependsOn(`scalechain-util`, `scalechain-net`, `scalechain-transaction`, `scalechain-wallet`, `scalechain-api`)

lazy val `scalechain-consensus` =
  project.in(file("./scalechain-consensus"))

lazy val `scalechain-crypto` =
  project
    .in(file("./scalechain-crypto"))
    .dependsOn(`scalechain-util`)

lazy val `scalechain-net` =
  project
    .in(file("./scalechain-net"))
    .dependsOn(
      `scalechain-util`,
      `scalechain-proto`,
      `scalechain-consensus`,
      `scalechain-proto-codec`,
      `scalechain-script`,
      `scalechain-chain`,
      `scalechain-transaction`,
      `scalechain-wallet`
    )

lazy val `scalechain-proto` =
  project
    .in(file("./scalechain-proto"))
    .dependsOn(`scalechain-util`)

lazy val `scalechain-proto-codec` =
  project
    .in(file("./scalechain-proto-codec"))
    .dependsOn(`scalechain-util`, `scalechain-proto`, `scalechain-crypto`)

lazy val `scalechain-proto-script` =
  project
    .in(file("./scalechain-proto-script"))
    .dependsOn(`scalechain-util`, `scalechain-proto-codec`, `scalechain-crypto`, `scalechain-proto`)

lazy val `scalechain-script` =
  project
    .in(file("./scalechain-script"))
    .dependsOn(`scalechain-util`, `scalechain-crypto`, `scalechain-proto-codec`)

lazy val `scalechain-storage` =
  project
    .in(file("./scalechain-storage"))
    .dependsOn(`scalechain-util`, `scalechain-proto`, `scalechain-proto-codec`, `scalechain-script`)

lazy val `scalechain-transaction` =
  project
    .in(file("./scalechain-transaction"))
    .dependsOn(`scalechain-util`, `scalechain-script`, `scalechain-storage`)

lazy val `scalechain-util` =
  project.in(file("./scalechain-util"))

lazy val `scalechain-wallet` =
  project
    .in(file("./scalechain-wallet"))
    .dependsOn(`scalechain-util`, `scalechain-chain`, `scalechain-storage`, `scalechain-transaction`)

ThisBuild / libraryDependencies ++= Seq(
  "io.netty"                    % "netty-all"               % "4.1.6.Final",
  "io.spray"                   %% "spray-json"              % "1.3.6",
  "ch.qos.logback"              % "logback-classic"         % "1.1.7",
  "com.typesafe.scala-logging" %% "scala-logging"           % "3.9.3",
  "org.scalatest"              %% "scalatest"               % "3.2.9",
  "org.scalacheck"             %% "scalacheck"              % "1.15.4",
  "commons-io"                  % "commons-io"              % "2.5",
  "org.eclipse.collections"     % "eclipse-collections"     % "8.0.0",
  "org.eclipse.collections"     % "eclipse-collections-api" % "8.0.0",
  "com.thesamet.scalapb"       %% "scalapb-runtime"         % scalapb.compiler.Version.scalapbVersion % "protobuf"
)

Test / fork := true
Test / parallelExecution := true
Test / logLevel := Level.Warn

Compile / PB.targets := Seq(
  scalapb.gen() -> (Compile / sourceManaged).value / "scalapb"
)

scalafmtOnCompile := true
