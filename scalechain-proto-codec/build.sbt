//////////////////////////////////////////////////////////////////////////
// scalechain-proto-codec/build.sbt
//////////////////////////////////////////////////////////////////////////

Compile / PB.targets := Seq(
  scalapb.gen() -> (Compile / sourceManaged).value / "scalapb"
)

//PB.javaConversions in PB.protobufConfig := true

libraryDependencies ++= Seq(
  "org.scodec" %% "scodec-core" % "1.11.8",
  "org.scalacheck"%% "scalacheck" % "1.15.4",
  "org.scalatestplus" %% "scalacheck-1-15" % "3.2.9.0",
  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"

)