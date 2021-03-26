package OOP

import scala.util.Try

object Start extends App{

  def AgeTry: Int = {
    println("Enter your age below:")
    val age: Int = scala.io.StdIn.readInt()
    if (age >0) {
      age
    } else {
      throw new Exception("Ne to")
    }
  }

  def getAgeTry: Try[Int] = {
    println("Enter your age below:")
    val age: Int = scala.io.StdIn.readInt()
    Try {
      if (age > 0) {
        age
      } else {
        throw new Exception("Ne to")
      }
    }
  }
  Try(AgeTry)
  getAgeTry
  println("spasibo")
}
