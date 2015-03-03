private val board = Array.ofDim[String](3, 3)

board(0)(0) = "a"
board(0)(1) = "a"
board(0)(2) = "a"

board(1)(0) = "b"
board(1)(1) = "b"

board(2)(1) = "z"

println(board(2)(0)+ "    " + board(2)(1)+ "   " + board(2)(2))
println(board(1)(0)+ "    " + board(1)(1)+ "   " + board(1)(2))
println(board(0)(0)+ "    " + board(0)(1)+ "   " + board(0)(2))

//Takes in array of int, returns a boolean||
val pp: (Array[Int]) => Boolean = (row: Array[Int]) => row(3) == null

//lastIndexOf is being called on every element
val lastIndx = board.lastIndexOf(pp)

board.foreach((a)=> a.foreach(println(_)))



//[2]
//[1][1]
//[0][0][0]

//55
//45
//35



//val row = board.last((row: Array[String])=> row(3) == null)
//println("pkmo " + row)


//move p and free col