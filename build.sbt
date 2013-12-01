name := "bones"

version := "0.1"

scalaVersion := "2.10.2"

scalacOptions := Seq("-deprecation", "-unchecked", "-Xlint", "-feature", "-encoding", "utf8")

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/",
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
  "Restlet Repository" at "http://maven.restlet.org",
  "google-api-services" at "http://mavenrepo.google-api-java-client.googlecode.com/hg",
  "Spray Repository" at "http://repo.spray.cc/"
)


libraryDependencies ++= Seq(
  "org.specs2"                 %% "specs2"                        % "1.13"                % "test",
  "org.mockito"                %  "mockito-core"                  % "1.9.0"               % "test",
  "org.hamcrest"               %  "hamcrest-core"                 % "1.3"                 % "test"
)