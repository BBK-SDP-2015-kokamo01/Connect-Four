import org.scalatest.FlatSpec

class AiSpec extends FlatSpec {

  "AI" should "create a game tree" in {
    val ai = AI
    val player = RED
    val board = Board()
    val move = new Move(player, 3)

    val state = new State(player, board, move)

    ai.createGameTree(state, 5)
    state.writeToFile()
  }
}
