package jp.co.bizreach.trace.play.sender
import java.util

import play.api.Logger
import zipkin2.Call
import zipkin2.codec.Encoding
import zipkin2.reporter.Sender

/**
  * A Zipkin Reporter [[Sender]] implementation which logs to sending spans.
  * Useful for debugging purpose.
  *
  * @param encoding
  */
class PlayLoggerSender(val encoding: Encoding) extends Sender {

  override def messageMaxBytes(): Int = Integer.MAX_VALUE

  override def messageSizeInBytes(encodedSpans: util.List[Array[Byte]]): Int = encoding.listSizeInBytes(encodedSpans)

  override def sendSpans(encodedSpans: util.List[Array[Byte]]): Call[Void] = {
    import scala.collection.JavaConverters._

    encodedSpans.asScala.map(new String(_))
      .foreach(span => Logger.info(s"Send span: $span"))

    Call.create(null);
  }
}
