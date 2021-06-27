//////////////////////////////////////////////////////////////////////////
// scalechain-cli/build.sbt
//////////////////////////////////////////////////////////////////////////

//import Version._
libraryDependencies ++= {
  Seq(
    // spark-core : SparkLoader.scala uses it.
    // "org.apache.spark" %% "spark-core" % "1.6.1",
    "com.github.scopt"  %% "scopt" % "4.0.1"
  )
}

resolvers += Resolver.sonatypeRepo("public")