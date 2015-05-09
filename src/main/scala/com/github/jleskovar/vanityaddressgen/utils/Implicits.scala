package com.github.jleskovar.vanityaddressgen.utils

import com.codahale.metrics.Counter

/**
 * Created by james on 9/05/15.
 */
object Implicits {
  implicit class EnrichedIterator[A](val self: Iterator[A]) extends AnyVal {
    def withMetrics(counter: Counter): Iterator[A] = new RateTrackingIterator[A](self, counter)
  }
}
