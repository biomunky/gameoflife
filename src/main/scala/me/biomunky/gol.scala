package me.biomunky

case class Cell(x: Int, y: Int)

case class Grid(x: Int, y: Int, livingCells: List[Cell]) {
  def contains(cell: Cell) = livingCells contains cell
  def draw() = {
    (for (i <- 0 until x; j <- 0 until y) yield { if (livingCells.contains(Cell(i, j))) "x" else "-" })
      .toList
      .sliding(3,3)
      .toList
      .map { _.mkString("") } mkString "\n"
  }
}

class GOL {
  def neighbours(cell: Cell): List[Cell] = {
     val positions = List(-1, 0, 1)
     positions flatMap (x =>
       positions.map (y =>
         Cell(cell.x+x, cell.y+y))
       ) filterNot (_ == cell )
  }

  def candidates(livingCells: List[Cell]): Map[Cell, Int] = {
    livingCells
      .flatMap(neighbours)
      .foldLeft(Map.empty[Cell, Int]) { (amap, acell) => amap ++ Map(acell -> (amap.getOrElse(acell, 0) + 1)) }
  }

  def step(grid: Grid) = {
    val newCells = candidates(grid.livingCells).filter { case (loc, living) =>
      living == 3 || living == 2 && grid.contains(loc)
    }
    .keys
    .toList
    grid.copy(livingCells = newCells)
  }
}
