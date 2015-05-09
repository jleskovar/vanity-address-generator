package com.github.jleskovar.vanityaddressgen.utils

import com.codahale.metrics.{Counter, MetricRegistry}
import org.scalatest._
import Implicits._

/**
 * Created by james on 9/05/15.
 */
class RateTrackingIteratorTests extends FunSuite with BeforeAndAfter with Matchers {
  var metrics: MetricRegistry = _

  before {
    metrics = new MetricRegistry
  }

  test("no metrics recorded for empty iterator") {
    val counter: Counter = metrics.counter("mycounter")
    counter.getCount shouldBe 0
    Iterator.empty.withMetrics(counter).toList
    counter.getCount shouldBe 0
  }

  test("metrics recorded for non-empty iterator") {
    val counter: Counter = metrics.counter("mycounter")
    counter.getCount shouldBe 0
    (1 to 10).toIterator.withMetrics(counter).toList
    counter.getCount shouldBe 10
  }

}
