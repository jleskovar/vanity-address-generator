package com.github.jleskovar.vanityaddressgen.generator

import com.codahale.metrics.Meter
import com.github.jleskovar.vanityaddressgen.utils.Implicits
import org.bitcoinj.core.ECKey
import Implicits._

trait EllipticCurveKeyProvider {
  def keys: Iterator[ECKey]
}

object EllipticCurveKeyProvider {
  class ContinuousEllipticCurveKeyProvider extends EllipticCurveKeyProvider {
    def keys: Iterator[ECKey] = Iterator.continually(new ECKey)
  }

  class MetricTrackingEllipticCurveKeyProvider(meter: Meter) extends ContinuousEllipticCurveKeyProvider {
    override def keys: Iterator[ECKey] = super.keys.metered(meter)
  }
}
