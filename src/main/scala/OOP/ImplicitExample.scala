package OOP

object ImplicitExample {
  case class Team(name: String)
  case class Player(nick: String)


  def setup(player1: Player, player2: Player, player3: Player, player4: Player, player5: Player)(implicit team: Team): Unit = {
    val teamMembers: String = player1.nick + "," + player2.nick + "," + player3.nick + "," + player4.nick + "," + player5.nick
    println(teamMembers + " играют за " + team.name)
  }

  implicit val ourTeam = Team("Террористы")

  val p1 = Player("Алексей")
  val p2 = Player("Амина")
  val p3 = Player("Артем")
  val p4 = Player("Родион")
  val p5 = Player("Дмитриус")

  // setup(p1, p2, p3, p4, p5)

  // Немножко о том, что тут происходит нового

  // 1) метод setup имеет 2 группы параметров (  2 группы скобок (...)(...)   ) - Это называеться КАРРИРОВАНИЕ.
  // Все что делает КАРРИРОВАНИЕ это позволяет иметь 2 группы параметров. 3 и более групп нельзя.
  // Разницы в работе нету, просто считайте, что через скобочки можно логически отделять параметры.
  // Но практически всегда -  это используют для НЕЯВНЫХ/ИМАЛИСИТНЫХ параметров.

  // 2) Что бы параметры стали неявными, достаточно указать в параметрах метода слово implicit.
  // ВСЕ ВСЕ ВСЕ параметры после implicit будут неявными, по этому их надо ставить в конце списка или использовать каррирование.

  // ЧТО ВООБЩЕ ДЕЛАЕТ implicit в параметрах ?
  // 3) Как можно заметить, то мы сделали вызов setup(p1, p2, p3, p4 ,p5) не передав в него параметр ourTeam
  // Компилятор скалы сам подставил его в метод. Собственно, это все что тут происходит.

  // Важно!
  // Что бы компилятор смог подставить, то необходимо переменную тоже указать как implicit val ourTeam
  // Компилятор ищет среди неявных переменных ту, что подходит по типу и подставляет в метод.
  // Если вдруг он найдет 2 неявные переменные одного типа, то это будет ошибка в программе и программа даже не заработает.
  // Например, если создавть вторую команду и отметить её implicit то будет ошибка


  // ----------------------------------------------------------------------------------------------------------------------------



  //                                                      implicit def

  case class Student(name: String)
  case class Teacher(name: String)

  def seyHelloTo(student: Student): Unit = {
    println("Hello " + student.name)
  }

  implicit def studentToTeacher(teacher: Teacher): Student = { // позволяет неявно превратить один тип в другой
    Student(teacher.name)
  }

  val student = Student("Leha")
  val teacher = Teacher("GLeb")

  seyHelloTo(student)
  seyHelloTo(teacher) // теперь мы можем передавать в метод учителя, вместо студента.
  // Потому что превращение произойдет автоматически

  // тоже самое что и  seyHelloTo(studentToTeacher(teacher))
}
