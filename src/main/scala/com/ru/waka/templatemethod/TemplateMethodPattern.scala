package com.ru.waka.templatemethod

object TemplateMethodPattern {
  def main(args: Array[String]) {
    val d1 = new CharDisplay('H')
    val d2 = new StringDisplay("Hello, World")
    d1.display()
    d2.display()
  }

}

abstract class AbstractDisplay {
  def open(): Unit

  def print(): Unit

  def close(): Unit

  final def display(): Unit = {
    open()
    for(i <- 1 to 6) {
      print()
    }
    close()
  }
}

class CharDisplay(ch: Char) extends AbstractDisplay {
  override def open(): Unit = println("<<")

  override def close(): Unit = println(">>")

  override def print(): Unit = printf(ch.toString)
}

class StringDisplay(str: String) extends AbstractDisplay {
  val width = str.getBytes.length

  override def open(): Unit = printLine()

  override def close(): Unit = printLine()

  override def print(): Unit = println(s"|$str|")

  private def printLine(): Unit = {
    printf("+")
    for(i <- 0 until width) {
      printf("-")
    }
    println("+")
  }
}