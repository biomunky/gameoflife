package me.biomunky

import org.specs2.mutable.Specification


class GridTest extends Specification {
  "Grid" should {
    "draw" in {
      val grid = Grid(3, 3, List(Cell(0, 1), Cell(1, 1), Cell(2, 1)))
      grid.draw() mustEqual "-x-\n-x-\n-x-"
    }
  }
}


class GOLTest extends Specification {

  "GOL" should {

    val game = new GOL

    "return neighbours" in {
      game.neighbours(Cell(1,1)) mustEqual List(Cell(0,0), Cell(0,1), Cell(0,2), Cell(1,0), Cell(1,2), Cell(2,0), Cell(2,1), Cell(2,2))
      game.neighbours(Cell(0,0)) mustEqual List(Cell(-1,-1), Cell(-1,0), Cell(-1,1), Cell(0,-1), Cell(0,1), Cell(1,-1), Cell(1,0), Cell(1,1))
    }

    "return possible candidates" in {
      val livingCells = List(Cell(0,0), Cell(0,2), Cell(2,0), Cell(2,2))
      val desired = Map(
        Cell(-1,-1) -> 1,
        Cell(2,-1)  -> 1,
        Cell(3,1)   -> 2,
        Cell(0,3)   -> 1,
        Cell(3,0)   -> 1,
        Cell(1,1)   -> 4,
        Cell(1,-1)  -> 2,
        Cell(-1,0)  -> 1,
        Cell(3,2)   -> 1,
        Cell(1,3)   -> 2,
        Cell(-1,2)  -> 1,
        Cell(-1,3)  -> 1,
        Cell(0,1)   -> 2,
        Cell(-1,1)  -> 2,
        Cell(3,3)   -> 1,
        Cell(2,3)   -> 1,
        Cell(1,2)   -> 2,
        Cell(2,1)   -> 2,
        Cell(1,0)   -> 2,
        Cell(0,-1)  -> 1,
        Cell(3,-1)  -> 1
      )
      game.candidates(livingCells) mustEqual desired
    }

    "take a step" in {
      val livingCells = List(Cell(0, 1), Cell(1, 1), Cell(2, 1))
      val grid = Grid(3, 3, livingCells)
      val newGrid = game.step(grid)
      newGrid.livingCells should containAllOf(List(Cell(1, 0), Cell(1, 1), Cell(1, 2)))
    }
  }
}
