package com.ru.waka.adapter

object AdapterPattern {
  def main(args: Array[String]) {
    val p = new PrintBanner("Hello")
    p.showWithAster()
    p.showWithParen()
    val p2 = new PrintBanner("Hello")
    p2.showWithAster()
    p2.showWithParen()
  }
}

class Banner(str: String) {
  def showWithParen(): Unit = println(s"(${str})")

  def showWithAster(): Unit = println(s"*${str}*")
}

trait Print {
  def printWeek(): Unit

  def printStrong(): Unit
}

class PrintBanner(str: String) extends Banner(str) with Print {
  override def printWeek(): Unit = showWithParen()

  override def printStrong(): Unit = showWithAster()
}

class PrintBanner2(banner: Banner) extends Print {
  override def printWeek(): Unit = banner.showWithParen()

  override def printStrong(): Unit = banner.showWithAster()
}
