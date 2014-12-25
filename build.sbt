name := "a100-spark"

organization  := "com.hikvision.a100"

version       := "0.1"

scalaVersion  := "2.10.3"

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

scalacOptions ++= Seq("-encoding", "UTF-8", "-target:jvm-1.7")

javacOptions ++= Seq("-encoding", "UTF-8", "-source", "1.7", "-target", "1.7")

compileOrder := CompileOrder.JavaThenScala

libraryDependencies ++= {
  val akkaV = "2.3.0"
  val sprayV = "1.3.1"
  Seq(
    "org.apache.spark" %% "spark-core" % "1.1.0",
    "junit" % "junit" % "4.4" % "test"
  )
}
