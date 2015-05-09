package com.github.jleskovar.vanityaddressgen.utils

import com.codahale.metrics.Meter

/**
 * Created by james on 9/05/15.
 */
object Implicits {
  implicit class EnrichedIterator[A](val self: Iterator[A]) extends AnyVal {
    def withMetrics(meter: Meter): Iterator[A] = new RateTrackingIterator[A](self, meter)
  }
}
