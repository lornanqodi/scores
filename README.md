# scores
Calculates rankings for teams in a league

To run this project, clone from remote repo:
```bash
$ https://github.com/lornanqodi/scores.git
```

##Pre-requisites
1. Make sure you have the Java 11 JDK or higher
2. Ensure sbt version 1.5.5 or later is installed
3. Ensure that scala 2.13.3 or later is installed

## Run application with an IDE
1. Create the input file and save it in the root directory of the project
2. Set the program arguments to the file name
3. Run the Main.scala class


## Run the application with SBT
```bash
$ sbt assembly 
$ sbt run <input file name>
```

## Run the application with scala CLI
```bash
$ scalac Main.scala
$ scala Main <input file name>
```

## Run tests
Add the following module to the project: 
org.scalatest.FreeSpec
``` bash
$ sbt test
```