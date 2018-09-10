package jp.co.bizreach.trace.play.sender
import java.util

import zipkin2.Call
import zipkin2.codec.Encoding
import zipkin2.reporter.Sender

/**
  * A Zipkin Reporter [[Sender]] implementation which does nothing.
  * Can be used to disable sending data to Zipkin backend.
  */
class NoopSender(val encoding: Encoding) extends Sender {

  override def messageMaxBytes(): Int = Integer.MAX_VALUE

  override def messageSizeInBytes(encodedSpans: util.List[Array[Byte]]): Int = encoding.listSizeInBytes(encodedSpans)

  override def sendSpans(encodedSpans: util.List[Array[Byte]]): Call[Void] = Call.create(null);
}
