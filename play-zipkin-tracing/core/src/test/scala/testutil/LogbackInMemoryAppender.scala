package testutil
import ch.qos.logback.core.AppenderBase
import ch.qos.logback.core.encoder.Encoder

/**
  * In-memory Logback appender to be able to test logged messages.
  */
class LogbackInMemoryAppender[E] extends AppenderBase[E] {

  var encoder: Encoder[E] = null

  override def append(eventObject: E): Unit = {
    LogbackMemory.enqueue(new String(this.encoder.encode(eventObject)))
  }

  def setEncoder(encoder: Encoder[E]): Unit = {
    this.encoder = encoder
  }
}

/**
  * Singleton holding all logged messages in memory
  */
object LogbackMemory {
  private val queue = collection.mutable.Queue.empty[String]

  def enqueue(msg: String): Unit = queue.enqueue(msg)
  def dequeue: String = queue.dequeue
}
