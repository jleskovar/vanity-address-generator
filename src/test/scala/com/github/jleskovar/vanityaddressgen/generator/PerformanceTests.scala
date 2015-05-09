package com.github.jleskovar.vanityaddressgen.generator

import java.util.concurrent.TimeUnit

import com.codahale.metrics.{ConsoleReporter, MetricRegistry}
import com.github.jleskovar.vanityaddressgen.generator.EllipticCurveKeyProvider.{MetricTrackingEllipticCurveKeyProvider, ContinuousEllipticCurveKeyProvider}
import org.bitcoinj.core.NetworkParameters
import org.scalatest.{Ignore, FunSuite, Matchers}

object PerformanceTests {
  val metrics = new MetricRegistry
  val meterName: String = "performance.test"
}

/**
 * Created by james on 6/05/15.
 */
@Ignore
class PerformanceTests extends FunSuite with Matchers {

  val networkParameters: NetworkParameters = NetworkParameters.fromID(NetworkParameters.ID_MAINNET)
  val ecKeyProvider = new MetricTrackingEllipticCurveKeyProvider(PerformanceTests.metrics.meter(PerformanceTests.meterName))
  val addressGenerator = new VanityAddressGenerator(networkParameters, ecKeyProvider)

  test("performance of vanity address generation") {
    val reporter = ConsoleReporter.forRegistry(PerformanceTests.metrics)
      .convertRatesTo(TimeUnit.SECONDS)
      .convertDurationsTo(TimeUnit.MILLISECONDS)
      .build()

    reporter.start(1, TimeUnit.SECONDS)
    addressGenerator.findAddressWithPrefix("1Leskovar")

  }

}
