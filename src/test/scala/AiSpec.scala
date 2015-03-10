import org.scalatest.FlatSpec

class AiSpec extends FlatSpec {

  "AI" should "create a game tree" in {
    val ai = AI
    val player = RED
    val board = Board()
    val move = new Move(player, 3)

    val move1 = new Move(player, 0)
    val move2 = new Move(player, 0)
    val move3 = new Move(player, 0)
    val move4 = new Move(player, 0)

    board.makeMove(move1)
    board.makeMove(move2)
    board.makeMove(move3)

    val opponent = YELLOW
    val move5 = new Move(opponent, 1)
    board.makeMove(move5)

    val state = new State(player, board, move)

    ai.createGameTree(state, 3)
    state.writeToFile()
  }
}
