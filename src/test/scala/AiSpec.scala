import org.scalatest.FlatSpec

/**
 * Manual tests.
 */
class AiSpec extends FlatSpec {

  "AI" should "create a game tree" in {
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

    AI.createGameTree(state, 3)
    state.writeToFile()
  }

  "AI" should "evaluate minimax" in {
    val player = RED
    val depth = 3

    val board = Board()
    val move1 = new Move(player, 0)
    val state = new State(player, board, move1)

    AI.createGameTree(state, depth)
    val ai = new AI(player, depth);
    ai.minimax(state)
    state.writeToFile()
  }
}
