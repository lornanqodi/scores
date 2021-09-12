lazy val root = project
  .in(file("."))
  .settings(
    name := "scores",
    version := "0.1",
    scalaVersion := "2.13.3",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.+",
    resolvers += Resolver.url("typesafe", url("https://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns),
    idePackagePrefix := Some("com.github.scores")
  )

