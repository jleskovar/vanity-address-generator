package com.github.jleskovar.vanityaddressgen.utils

import com.codahale.metrics.Counter

/**
 * Created by james on 9/05/15.
 */
class RateTrackingIterator[T](iterator: Iterator[T], counter: Counter) extends Iterator[T] {
  override def hasNext: Boolean = iterator.hasNext

  override def next(): T = {
    counter.inc()
    iterator.next()
  }
}
