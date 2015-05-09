package com.github.jleskovar.vanityaddressgen.generator

import java.security.SecureRandom

import com.github.jleskovar.vanityaddressgen.generator.EllipticCurveKeyProvider.ContinuousEllipticCurveKeyProvider
import org.bitcoinj.core.{Address, ECKey, NetworkParameters}

/**
 * Created by james on 6/05/15.
 */
class VanityAddressGenerator(network: NetworkParameters,
                             ecKeyProvider: EllipticCurveKeyProvider = new ContinuousEllipticCurveKeyProvider(),
                             random: SecureRandom = new SecureRandom())
  extends AddressGenerator {

  override def findAddressWithPrefix(prefix: String): Option[(Address, ECKey)] = {
    ecKeyProvider.keys.find(key => new Address(network, key.getPubKeyHash).toString.startsWith(prefix)).map {
      case key => (new Address(network, key.getPubKeyHash), key)
    }
  }
}
