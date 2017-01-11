name := "SbtWebTest"

version := "1.0"

lazy val scalaV = "2.12.1"

lazy val app = (project in file("app")).settings(
  scalaVersion := scalaV,
  scalaJSProjects := Seq(client),
  pipelineStages in Assets := Seq(scalaJSPipeline),
  compile in Compile := ((compile in Compile) dependsOn scalaJSPipeline).value
).enablePlugins(SbtWeb)

lazy val client = (project in file("client")).settings(
  scalaVersion := scalaV,
  persistLauncher := true,
  persistLauncher in Test := false
).enablePlugins(ScalaJSWeb, ScalaJSPlugin)
