package com.github.jleskovar.vanityaddressgen.generator

import java.security.SecureRandom

import org.bitcoinj.core.{Address, ECKey, NetworkParameters}

/**
 * Created by james on 6/05/15.
 */
class VanityAddressGenerator(network: NetworkParameters, random: Option[SecureRandom] = None) extends AddressGenerator {

  override def generateAddress(prefix: String): (Address, ECKey) = {
    var found = false
    var address: Address = null
    var key: ECKey = null

    val entropyProvider = random.getOrElse(new SecureRandom)

    while (!found) {
      key = new ECKey(entropyProvider)
      address = new Address(network, key.getPubKeyHash)
      if (address.toString.startsWith(prefix)) {
        found = true
      }
    }

    (address, key)
  }
}
