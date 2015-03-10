class AI(private var player: Player, private var depth: Int) extends Solver {

  override def getMoves(b: Board): Array[Move] = {
    b.getPossibleMoves(player)
  }

  def minimax(s: State) {
  }

  /**
   * This method will evaluate the nodes for us
   * @param b
   * @return
   */
  def evaluateBoard(b: Board): Int = {
    val winner = b.hasConnectFour() //option[Players]
    var value = 0
    if (!winner.isDefined) { //empty Option is present
      val locs = b.winLocations()//List[Array[Players]]
      for (loc <- locs; p <- loc) { // Double for loop
        value += (if (p == player) 1 else if (p != null) -1 else 0) //min max settings
      }
    } else {
      var numEmpty = 0
      var r = 0
      while (r < Board.NUM_ROWS) {
        var c = 0
        while (c < Board.NUM_COLS) {
          if (b.getTile(r, c) == null) numEmpty += 1 // counting empty cells
          c = c + 1
        }
        r = r + 1
      }
      value = (if (winner.get == player) 1 else -1) * 10000 * numEmpty // Setting node values
    }
    value
  }
}

object AI {

  def createGameTree(state: State, d: Int): Unit = {
    if (d == 0) return
    state.initializeChildren()
    state.getChildren.foreach(child => createGameTree(child, d-1))
  }

  def minimax(ai: AI, s: State) {
    ai.minimax(s)
  }
}

