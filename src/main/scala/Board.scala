import javax.swing.BorderFactory

import scala.collection.GenSeq
import scala.collection.mutable.ListBuffer

class Board {

  private val FOUR = 4

  private val deltas = Array(Array(1, 0), Array(0, 1), Array(-1, 1), Array(1, 1))

  private val board = Array.ofDim[Player](Board.NUM_ROWS, Board.NUM_COLS)

  def this(b: Board) {
    this()
    for (r <- 0 until Board.NUM_ROWS; c <- 0 until Board.NUM_COLS)
      board(r)(c) = b.board(r)(c)
  }

  def getPlayer(r: Int, c: Int): Player = {
    assert(0 <= r && r < Board.NUM_ROWS && 0 <= c && c < Board.NUM_COLS)
    board(r)(c)
  }

  def this(b: Board, nextMove: Move) {
    this(b)
    makeMove(nextMove)
  }

  //Java!
//  def makeMove(move: Move): Unit = {
//    var row = Board.NUM_ROWS - 1;
//    while (getTile(row, move.column) != null) row -= 1
//    board(row)(move.column) = move.player
//  }

//  //Anonymous function Scala!
//  def makeMove(move: Move): Unit = {
//    val row = board.lastIndexWhere((row: Array[Player]) => row(move.column) == null)
//    board(row)(move.column) = move.player
//  }

  def makeMove(move: Move): Unit = {
    //if 5 has a piece it returns the one above
    //val p: (Array[Player]) => Boolean = _(move.column) == null

    val row = board.lastIndexWhere(_(move.column) == null) //_ infer variables, wildcard
    board(row)(move.column) = move.player
  }

  def getTile(row: Int, col: Int): Player = board(row)(col)

  def getPossibleMoves(p: Player): Array[Move] = {
    //get cells of the last row.
    // Move is made of: Move(var player: Player, var column: Int)
    //get the last empty row and pass the player and column in

    //if col has null it's available
    //val lastIndx = board.lastIndexOf((col: Array[Player]) => col(Board.NUM_COLS) == null)
    //var z = new Array[String](3)

    //search column for null if it has null break out
    //save row, col!
    //move on to next col
    //if not don't record

    val lastIndx = board.lastIndexOf((col: Array[Player]) => col(Board.NUM_COLS) == null)

//    var col = 0
//    var row = 0
//    while (col < Board.NUM_COLS) {
//      while (row < Board.NUM_ROWS) {
//        if (board(row)(col) == null){
//          //store it
//          col+=1
//        }
//        row+=1
//      }
//      val move: Move = new Move(p, col)
//    }

//    var col = 0;
//    var list: List(0);
//    while (col > Board.NUM_COLS){
//      val element = board(col).last
//      if (element != null) {
//        var a:Move = new Move(p, col)
//
//      }
//      return
//    }
  }

  override def toString(): String = ???

  def toString(prefix: String): String = {
    val str = new StringBuilder("")
    for (row <- board) {
      str.append(prefix + "|")
      for (spot <- row) {
        if (spot == null) {
          str.append(" |")
        } else if (spot == RED) {
          str.append("R|")
        } else {
          str.append("Y|")
        }
      }
      str.append("\n")
    }
    str.toString
  }

  def hasConnectFour(): Option[Player] = {
    winLocations().find(loc => loc(0) != null && loc(0) == loc(1) && loc(0) == loc(2) &&
      loc(0) == loc(3))
      .map(_(0))
      .orElse(None)
  }

  def winLocations(): List[Array[Player]] = {
    val locations = ListBuffer[Array[Player]]()
    for (delta <- deltas; r <- 0 until Board.NUM_ROWS; c <- 0 until Board.NUM_COLS) {
      val loc = possibleWin(r, c, delta)
      if (loc != null) {
        locations += loc
      }
    }
    locations.toList
  }

  def possibleWin(r: Int, c: Int, delta: Array[Int]): Array[Player] = {
    val location = Array.ofDim[Player](FOUR)
    for (i <- 0 until FOUR) {
      val newR = r + i * delta(0)
      val newC = c + i * delta(1)
      if (0 <= newR && newR < Board.NUM_ROWS && 0 <= newC && newC < Board.NUM_COLS) {
        location(i) = board(newR)(newC)
      }
    }
    location
  }
}

object Board {
  val NUM_ROWS = 6
  val NUM_COLS = 7

  def apply(b: Board): Board =
    new Board(b)

  def apply(): Board =
    new Board()
}
