//The simplest possible sbt build file is just one line:

scalaVersion := "2.13.13"

name    := "FlinkExample"
version := "1.0"

// https://mvnrepository.com/artifact/org.apache.flink/flink-streaming-java
libraryDependencies += "org.apache.flink" % "flink-streaming-java" % "1.19.1" % "compile->compile;test->test"

// Include only src/main/java in the compile configuration
Compile / unmanagedSourceDirectories := (Compile / javaSource).value :: Nil

// Include only src/test/java in the test configuration
Test / unmanagedSourceDirectories := (Test / javaSource).value :: Nil

scalacOptions += "-target:17"
//This way, we ensure the Scala compiler generates bytecode optimized for the Java 17 virtual machine.

javacOptions ++= Seq("-source", "17", "-target", "17")
//We can also set the source and target compatibility for the Java compiler by configuring the javacOptions in build.sbt:

//In order to run your job in a distinct JVM, add the following line to build.sbt

//fork in run := true

Runtime / fork := true
