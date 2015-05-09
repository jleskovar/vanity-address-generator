package com.github.jleskovar.vanityaddressgen.utils

import com.codahale.metrics.{Meter, MetricRegistry}
import com.github.jleskovar.vanityaddressgen.utils.Implicits._
import org.scalatest._

/**
 * Created by james on 9/05/15.
 */
class RateTrackingIteratorTests extends FunSuite with BeforeAndAfter with Matchers {
  var metrics: MetricRegistry = _

  before {
    metrics = new MetricRegistry
  }

  test("no metrics recorded for empty iterator") {
    val meter: Meter = metrics.meter("mymeter")
    meter.getCount shouldBe 0
    Iterator.empty.metered(meter).toList
    meter.getCount shouldBe 0
  }

  test("metrics recorded for non-empty iterator") {
    val meter: Meter = metrics.meter("mymeter")
    meter.getCount shouldBe 0
    (1 to 10).toIterator.metered(meter).toList
    meter.getCount shouldBe 10
  }

}
