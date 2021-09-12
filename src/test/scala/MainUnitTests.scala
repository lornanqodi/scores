package com.github.scores

import com.github.scores.{ScoreCalculator, Team}

import org.scalatest.FreeSpec

class MainUnitTests extends FreeSpec {
  val scoreCalculator = new ScoreCalculator

  "read file" - {
    "it can read input from a file and store result in object" in {
      val expectedOutput = List((Team("Lions", 3), Team("Snakes", 3)), (Team("Tarantulas", 1), Team("FC Awesome", 0)), (Team("Lions", 1), Team("FC Awesome", 1)),
        (Team("Tarantulas", 3), Team("Snakes", 1)), (Team("Lions", 4), Team("Grouches", 0)))
      assert(scoreCalculator.readFile("file.txt") == expectedOutput)
    }

    "it can determine a teams points from the score of a game" in {
      val gameResults = Seq((Team("Lions", 3), Team("Snakes", 3)), (Team("Tarantulas", 1), Team("FC Awesome", 0)), (Team("Lions", 1), Team("FC Awesome", 1)),
        (Team("Tarantulas", 3), Team("Snakes", 1)), (Team("Lions", 4), Team("Grouches", 0)))
      val expectedOutput = List((("Tarantulas", 6), 0), (("Lions", 5), 1), (("FC Awesome", 1), 2), (("Snakes", 1), 3), (("Grouches", 0), 4))
      assert(scoreCalculator.calculatePoints(gameResults) == expectedOutput)
    }

    "sort output in alphabetical order" in {
      val gameResults = Seq(Team("Lions", 1), Team("Snakes", 1), Team("Seals", 1), Team("Savages", 1), Team("Leopards", 1), Team("Lizards", 1))
      scoreCalculator.rankScoreboard(gameResults)

      val expectedOutput = Seq((("Leopards", 1), 0), (("Lions", 1), 1), (("Lizards", 1), 2), (("Savages", 1), 3), (("Seals", 1), 4), (("Snakes", 1), 5))
      assert(scoreCalculator.rankScoreboard(gameResults) == expectedOutput)
    }
  }
}