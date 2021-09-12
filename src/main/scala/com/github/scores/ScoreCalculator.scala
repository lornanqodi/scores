package com.github.scores
package com.github.scores

import scala.io.Source

class ScoreCalculator {
  def rankScoreboard(teamPoints: Seq[Team]): Seq[((String, Int), Int)] = {
    teamPoints.groupBy(_.name).toSeq.map(team => team._1 -> team._2.map(_.points).sum).sortBy(_._1).sortWith(_._2 > _._2).zipWithIndex
  }

  def printResult(rank: Int, name: String, points: Int): String = {
    s"$rank. $name, $points pts"
  }

  def calculatePoints(gameResults: Seq[(Team, Team)]): Seq[((String, Int), Int)] = {
    rankScoreboard(gameResults.flatMap(team => {
      team._1.points.compareTo(team._2.points) match {
        case -1 => Seq(Team(team._1.name, Points.Loss.id), Team(team._2.name, Points.Win.id))
        case 0 => Seq(Team(team._1.name, Points.Tie.id), Team(team._2.name, Points.Tie.id))
        case 1 => Seq(Team(team._1.name, Points.Win.id), Team(team._2.name, Points.Loss.id))
      }
    }))
  }

  def readFile(filename: String): Seq[(Team, Team)] = {
    val source = Source.fromFile(s"./$filename")
    val lines = for (line <- source.getLines()) yield {
      val game = line.split(",")
      val team1 = game.head.splitAt(game.head.length - 2)
      match {
        case (name, score) => Team(name, score.trim.toInt)
      }

      val team2 = game.apply(1).splitAt(game.apply(1).length - 2)
      match {
        case (name, score) => Team(name.stripLeading(), score.trim.toInt)
      }
      (team1, team2)
    }
    lines.toSeq
  }
}

object Points extends Enumeration {
  type Points = Value

  val Win: Value = Value(3)
  val Tie: Value = Value(1)
  val Loss: Value = Value(0)

}

case class Team(name: String, points: Int)


