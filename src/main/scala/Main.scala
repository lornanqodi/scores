package com.github.scores

import com.github.scores.ScoreCalculator

import java.io.FileNotFoundException

object Main {
  def main(args: Array[String]): Unit = {
    val score = new ScoreCalculator()
    try {
      val filename = args.apply(0)
      val gameResults = score.readFile(filename)
      val scoreboard = score.calculatePoints(gameResults)
      scoreboard.foreach(x => score.printResult(x._2 + 1, x._1._1, x._1._2))
    } catch {
      case e: FileNotFoundException => new FileNotFoundException(e.getMessage)
      case e: Exception => throw e
    }

  }
}
