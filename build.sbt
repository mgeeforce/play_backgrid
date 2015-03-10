name := "backgrid"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "mysql" % "mysql-connector-java" % "5.1.30",
  "org.webjars" %% "webjars-play" % "2.2.2-1",
  "org.webjars" % "bootstrap" % "3.1.1-1",
  "org.webjars" % "jquery" % "2.1.1",
  "org.webjars" % "backgrid" % "0.3.5",
  "org.webjars" % "bootstrap-datepicker" % "1.3.0",
  "org.webjars" % "momentjs" % "2.5.0"  
)     

play.Project.playJavaSettings
