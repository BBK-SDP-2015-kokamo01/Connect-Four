class AI(private var player: Player, private var depth: Int) extends Solver {

  override def getMoves(board: Board): Array[Move] = {
    board.getPossibleMoves(player)
      .map(score(board))
      .sortBy(descendingValue)
      .map(_.getLastMove)
  }

  private def descendingValue: (State) => Int = state => -state.getValue

  private def score(b: Board): (Move) => State =
    nextMove => {
      val state = new State(player, new Board(b, nextMove), nextMove)
      AI.createGameTree(state, depth)
      minimax(state)
      state
    }

  def minimax(state: State): Unit = {
    val children = state.getChildren
    children.foreach(minimax)

    if (children.isEmpty) {
      state.setValue(evaluateBoard(state.getBoard))
    } else {
      val values = children.map(_.getValue)
      state.setValue(if(player == state.getPlayer) values.min else values.max)
    }
  }

  def evaluateBoard(b: Board): Int = {
    val winner = b.hasConnectFour()
    var value = 0
    if (!winner.isDefined) {
      val locs = b.winLocations()
      for (loc <- locs; p <- loc) {
        value += (if (p == player) 1 else if (p != null) -1 else 0)
      }
    } else {
      var numEmpty = 0
      var r = 0
      while (r < Board.NUM_ROWS) {
        var c = 0
        while (c < Board.NUM_COLS) {
          if (b.getTile(r, c) == null) numEmpty += 1
          c = c + 1
        }
        r = r + 1
      }
      value = (if (winner.get == player) 1 else -1) * 10000 * numEmpty
    }
    value
  }
}

object AI {

  def createGameTree(state: State, d: Int): Unit = {
    if (d == 0 || state.getBoard.hasConnectFour().isDefined) return
    state.initializeChildren()
    state.getChildren.foreach(child => createGameTree(child, d-1))
  }

  def minimax(ai: AI, s: State) {
    ai.minimax(s)
  }
}

