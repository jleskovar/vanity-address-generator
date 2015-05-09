package com.github.jleskovar.vanityaddressgen.utils

import com.codahale.metrics.Meter

/**
 * Created by james on 9/05/15.
 */
class RateTrackingIterator[T](iterator: Iterator[T], meter: Meter) extends Iterator[T] {
  override def hasNext: Boolean = iterator.hasNext

  override def next(): T = {
    meter.mark()
    iterator.next()
  }
}
