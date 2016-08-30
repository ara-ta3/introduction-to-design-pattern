package com.ru.waka.builder

object BuilderPattern {

}

abstract class Builder {
  def makeTitle(title: String): Unit

  def makeString(str: String): Unit

  def makeItems(items: Seq[String]): Unit

  def close(): Unit
}

class Director(builder: Builder) {
  def construct():Unit = {
    builder.makeTitle("Greeting")
    builder.makeString("あああああ")
    builder.makeItems(Seq(
      "aaa",
      "bbb"
    ))

    builder.makeString("AAAAA")
     builder.makeItems(Seq(
      "xxx",
      "yyy"
    ))
    builder.close()
  }
}
