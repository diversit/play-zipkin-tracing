package jp.co.bizreach.trace

object ZipkinTraceConfig {
  val AkkaName = "zipkin-trace-context"
  val ServiceName = "trace.service-name"
  val ZipkinBaseUrl = "trace.zipkin.base-url"
  val ZipkinSampleRate = "trace.zipkin.sample-rate"
  val zipkinSender = "trace.zipkin.sender"
}
