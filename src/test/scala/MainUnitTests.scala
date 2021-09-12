package com.github.scores

import org.scalatest.FreeSpec
import com.github.scores.ScoreCalculator

class MainUnitTests extends FreeSpec {

  val calc = new ScoreCalculator()
  "read file" - {

    "it reads file and stores in object" in {
      assert(calc.main == Seq(Some(1)) )
    }

    "should produce NoSuchElementException when head is invoked" in {
      assertThrows[NoSuchElementException] {
        Set.empty.head
      }
    }
  }
}