package OOP

import OOP.exampleOnRepeat.checkID.checkerID


import scala.util.{Failure, Success, Try}

//1
object exampleOnRepeat extends App {

  //  abstract class A {
  //    val b: Int
  //    val c: String
  //    val d: Option[Double]
  //  }
  //
  //  case class E(b: Int, c: String, d: Option[Double]) extends A
  //
  //  case class F(b: Int, c: String, d: Option[Double], g: Int) extends A
  //
  //  val e = E(2, "babaika", Some(2.4))
  //  val f = F(3, "babik", Some(2124.2), 76)

  //2
  case class ID(value: Int)

  object checkID {
    def checkerID(id: ID): Either[Int, String] = {
      val thisId = ID(id.value)
      if (thisId.value > 0) {
        Left(thisId.value)
      } else {
        Right("invalid ID")
      }
    }

  }

  val id = ID(0)

  // println(checkerID(id))
  // 3
  def getNameWithOption: Option[String] = {
    println("napishi svoe ebannoe name ili idi nahui")
    val ebannoeName: String = scala.io.StdIn.readLine.toUpperCase()

    if (ebannoeName == "ДА") {

      println("Ny davai, kak teb9 zovyt?")
      val name2: String = scala.io.StdIn.readLine()
      Some("welcome to the gay-club " + name2)

    } else {
      throw new Exception("poshel nahui, pidaras") // None
    }
  }

  //println(getNameWithOption)
  //4
  def getNameWithTry: Try[String] = {
    println("napishi svoe ebannoe name ili idi nahui")
    val ebannoeName: String = scala.io.StdIn.readLine.toUpperCase()

    if (ebannoeName == "ДА") {

      println("Ny davai, kak teb9 zovyt?")
      val name2: String = scala.io.StdIn.readLine()
      Success("welcome to the gay-club " + name2)

    } else {
      Failure(new Exception("poshel nahui, pidaras")) // None
    }
  }

  // println(getNameWithTry)

  //5
  def getNameWithEither: Either[String, String] = {
    println("Вводим ник?")
    val nicknameQuestion: String = scala.io.StdIn.readLine.toUpperCase()
    if (nicknameQuestion == "DA") {
      println("Говори.")
      val nickname: String = scala.io.StdIn.readLine()
      Left(nickname)

    } else {
      Right("bye-bye")
    }

  }
  //println(getNameWithEither)
//6
  def calculator() = {
    println("Введите первое значение!")
    val a = scala.io.StdIn.readInt()
    println("Введите второе значение")
    val b = scala.io.StdIn.readInt()
    println("что хотите сделать с этими числами?")
    println("из доступных команд есть: складывание, вычитание, умножение, деление")
    val questionAboutCommand: String = scala.io.StdIn.readLine()
    questionAboutCommand match {
      case "складывание" => println(a+b)
      case "вычитание" => println(a-b)
      case "умножение" => println(a*b)
      case "деление" => println(a/b)
    }



  }
  //println(calculator())
    //7

  case class User(FirstName: String, MiddleName:String, LastName:String)
    val firstName: Option[String] = Some("Иван")
    val middleName: Option[String] = Some("Иванович")
    val lastName: Option[String] = Some("Иванов")


    val SumFor: Option[User] = for {
      fn <- firstName
      mn <- middleName
      ln <- lastName
    }yield
    User(fn,mn,ln)
    println(SumFor)
}

