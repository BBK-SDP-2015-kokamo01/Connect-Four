import java.io.PrintWriter

//
//val board = Array.ofDim[Int](3, 3)
//    //R //C
//board(0)(0) = 9
//board(0)(1) = 1
//board(0)(2) = 1
//
//board(1)(0) = 2
//board(1)(1) = 2
//
//board(2)(1) = 8
//
//println(board(2)(0)+ "    " + board(2)(1)+ "   " + board(2)(2))
//println(board(1)(0)+ "    " + board(1)(1)+ "   " + board(1)(2))
//println(board(0)(0)+ "    " + board(0)(1)+ "   " + board(0)(2))
//
//
//board.foreach((a)=>{
//  a.foreach(print(_))
//  println()
//})
//
//board.transpose.foreach((a)=>{
//  a.foreach(print(_))
//  println()
//})
//
//val newBoard = board.transpose.zipWithIndex
//  .filter(a => a._1.contains(null))
//  .map(p => new Move(RED, p._2))
//
//newBoard

//(([0,2),null],0),([0,2,8],1))

//val posMove = newBoard.filter(a => a._1.contains(null))

//newBoard.foreach((a)=>{
//  println(a)
//})


//if a = null, there is a move availabel


/*
val vector1 = Vector(1,2,9,3,7,4,5)
val list = List(1,2,9,3,7,4,5)

val newVector = list.filter(_ % 2 == 1)
list.filter(_ % 2 == 1)

val fruit = Array("apple", "Orange", "grape", "tomato", "banana")
val fruitsWith5Letters = fruit.filter(n => n.length == 5)

val smellyFruit = fruit.map(e => e + "POO")
val list1 = List(2,3,4,5,6,2,1)
//val newList1 = list1.map(x => (x * 2))
val otherlist = List(1,2,3)
val list2 = List(5,4,3,2,1)
otherlist.zip(list2)
val listIndex = list2.view.zipWithIndex foreach {el => println(el._1, el._2)}
//list.fold()
*/

/*
val k = List(1,2,3)
k.map(n => n * 2)

val winner = Option.empty
println(!winner.isDefined)
*/

val writer = new PrintWriter("poo.txt", "UTF-8")
writer.println("poo")
writer.close()