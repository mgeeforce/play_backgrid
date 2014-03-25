name := "backgrid"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "mysql" % "mysql-connector-java" % "5.1.26",
  "org.webjars" %% "webjars-play" % "2.2.1" exclude("org.scala-lang", "scala-library"),
  "org.webjars" % "bootstrap" % "3.1.0",
  "org.webjars" % "jquery" % "2.0.3",
  "org.webjars" % "backgrid" % "0.3.5",
  "org.webjars" % "bootstrap-datepicker" % "1.3.0",
  "org.webjars" % "momentjs" % "2.5.0"  
)     

play.Project.playJavaSettings
