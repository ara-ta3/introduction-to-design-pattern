package com.ru.waka.iterator

import scala.collection.mutable.ArrayBuffer


/*
 * 本棚に本を入れて順番に表示するプログラム
 */
object IteratorPattern {
  def main(args: Array[String]) {
    val bookShelf = new BookShelf(5)
    bookShelf.appendBook(Book("aaa"))
    bookShelf.appendBook(Book("bbb"))
    bookShelf.appendBook(Book("ccc"))
    bookShelf.appendBook(Book("ddd"))
    val it = bookShelf.iterator()
    while (it.hasNext) {
      println(it.next.getName)
    }
  }

}

trait Aggregate[T] {
  def iterator(): Iterator[T]
}

trait Iterator[T] {
  def hasNext: Boolean

  def next: T
}

case class Book(private val name:String) {
  def getName: String = name
}

class BookShelf(maxSize: Int) extends Aggregate[Book] {
  private val books: ArrayBuffer[Book] = ArrayBuffer.empty[Book]

  def getBookAt(idx: Int): Book = books(idx)

  def appendBook(book: Book): Unit = books += book

  def getLength: Int = books.length

  def iterator(): Iterator[Book] = new BookShelfIterator(this)
}

class BookShelfIterator(bookShelf: BookShelf) extends Iterator[Book] {
  private var index = 0

  override def hasNext: Boolean = index < bookShelf.getLength

  override def next: Book = {
    val b = bookShelf.getBookAt(index)
    index += 1
    b
  }
}
