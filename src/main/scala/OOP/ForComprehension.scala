package OOP


  import scala.util.{Failure, Success, Try}
  object ForComprehansion extends App {

    // у нас есть опциональное имя
    val nameOpt: Option[String] = Some("Amina")

    // мы хотим всделать имя капсом, если имени нет то оставляем None

    // вот так можем сделать по старому, через матч
    val nameOptCAPSWithMatch: Option[String] =
      nameOpt match {
        case Some(name) => Some(name.toUpperCase)
        case None => None
      }

    // вот так можем сделать по новому, через мап
    val nameOptCAPSWithMap: Option[String] = nameOpt.map(name => name.toUpperCase)

    // вот эта штука .map(name => name.toUpperCase) это как будто автоматически сгенерированый одноразовый метод
    // def temp(name: String): String = name.toUpperCase

    // синтаксический сахар, нужен только для более красивого вида. Тоже самое что и с мап
    val nameOptCAPSWithFor: Option[String] =
      for {
        name <- nameOpt
      } yield name.toUpperCase


    //---------------------------------------------------------------------------------------------------------------
    // у нас есть не только имя, а и возраст. Оба опциональные.

    val newNameOpt: Option[String] = Some("Amina")
    val agwOpt: Option[Int] = Some(18)

    // если есть имя и возраст то склеиваем в строку, если чего нет то это None

    val namePlusAgeMatch: Option[String] = newNameOpt match {
      case Some(name) =>
        agwOpt match {
          case Some(age) =>
            // вариант что нам нужен
            Some(name + " " + age)
          case None => None
        }
      case None => None
    }

    val namePlusAgeFlatMap: Option[String] = newNameOpt.flatMap(name => agwOpt.map(age => name + " " + age))

    val namePlusAgeFor: Option[String] =





      for {
        name <- newNameOpt
        age <- agwOpt
      } yield name + " " + age
}
