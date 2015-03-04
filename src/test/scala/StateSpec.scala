import org.scalatest.{BeforeAndAfter, FlatSpec, ShouldMatchers}

class StateSpec extends FlatSpec with ShouldMatchers with BeforeAndAfter {
  var state: State = _
  var board: Board = _
  var move: Move = _
  var player: Player = _

  before {
    player = RED
    board = Board()
    move = new Move(player, 3)
    state = new State(player, board, move)
    state.initializeChildren()
  }

  "A state" should "be able to initialize children" in {
    state.getChildren.size should equal(board.getPossibleMoves(player).size)
  }

  "Child state" should "be initialized with the opponent" in {
    state.getChildren.foreach(_.getPlayer should be(player.opponent))
  }

  it should "be initialized with a copy of the board" in {
    state.getChildren.foreach(_.getBoard should not be theSameInstanceAs(board))
  }

  it should "be initialized with new move" in {
    state.getChildren.foreach(_.getLastMove should not be theSameInstanceAs(move))
  }
}
