package com.github.jleskovar.vanityaddressgen.generator

import java.security.SecureRandom

import org.bitcoinj.core.{Address, ECKey, NetworkParameters}

/**
 * Created by james on 6/05/15.
 */
class VanityAddressGenerator(val network: NetworkParameters, val random: SecureRandom = new SecureRandom())
  extends AddressGenerator {

  @volatile var counter: Long = _

  override def generateAddress(prefix: String): (Address, ECKey) = {
    var found = false
    var address: Address = null
    var key: ECKey = null

    while (!found) {
      key = new ECKey(random)
      address = new Address(network, key.getPubKeyHash)
      if (address.toString.startsWith(prefix)) {
        found = true
      }
      counter = counter + 1
    }

    (address, key)
  }
}
