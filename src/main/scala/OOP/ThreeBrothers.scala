package OOP

object ThreeBrothers {

  import scala.util.{Failure, Success, Try}

  object ThreeBrothers extends App {

    def getAgeOption: Option[Int] = {
      println("Option: enter age:")
      val age: Int = scala.io.StdIn.readInt()
      if (age > 0) {
        Some(age)
      } else {
        None
      }
    }

    val ageOpt = getAgeOption

    ageOpt match {
      case Some(age) => println("Option: age " + age)
      case None => println("Option: no age")
    }

    def getAgeTryV1: Try[Int] = {
      println("Try: enter age:")
      val age: Int = scala.io.StdIn.readInt()
      if (age > 0) {
        Success(age)
      } else {
        Failure(new Exception("Try: no age")) // ты пишешь где должна быть ошибка
      }
    }

    def getAgeTryV2: Try[Int] = {
      println("Try: enter age:")
      val age: Int = scala.io.StdIn.readInt()
      Try {
        if (age > 0) {
          age
        } else {
          throw new Exception("Try: no age") //само находит все ошибки
        }
      }
    }

    val ageTry = getAgeTryV1

    ageTry match {
      case Success(age) => println("Try: age " + age)
      case Failure(exception) => println(exception.getMessage)
    }

    def getAgeEither: Either[Int, String] = {
      println("Either: enter age:")
      val age: Int = scala.io.StdIn.readInt()
      if (age > 0) {
        Left(age)
      } else {
        Right("Either: no age")


      }
    }

    val ageEither = getAgeEither

    ageEither match {
      case Left(age) => println("Either: age " + age)
      case Right(msg) => println(msg)
    }


    val a: Option[Int] = ageTry.toOption

    val b: Option[String] = ageEither.toOption
  }

}