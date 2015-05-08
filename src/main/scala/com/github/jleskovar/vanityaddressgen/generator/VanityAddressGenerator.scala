package com.github.jleskovar.vanityaddressgen.generator

import java.security.SecureRandom

import org.bitcoinj.core.{Address, ECKey, NetworkParameters}

/**
 * Created by james on 6/05/15.
 */
class VanityAddressGenerator(val network: NetworkParameters, val random: SecureRandom = new SecureRandom())
  extends AddressGenerator {

  override def generateAddress(prefix: String): Option[(Address, ECKey)] = {
    ecKeys.find(key => new Address(network, key.getPubKeyHash).toString.startsWith(prefix)).map {
      case key => (new Address(network, key.getPubKeyHash), key)
    }
  }
}
