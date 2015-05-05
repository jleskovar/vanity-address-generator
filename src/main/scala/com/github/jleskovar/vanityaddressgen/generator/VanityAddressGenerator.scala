package com.github.jleskovar.vanityaddressgen.generator

import org.bitcoinj.core.{Address, ECKey, NetworkParameters}

/**
 * Created by james on 6/05/15.
 */
class VanityAddressGenerator extends AddressGenerator {

  override def generateAddress(prefix: String): (Address, ECKey) = {
    var flag = true
    var address: Address = null
    var key: ECKey = null
    while (flag) {
      key = new ECKey
      address = new Address(NetworkParameters.fromID(NetworkParameters.ID_MAINNET),
        key.getPubKeyHash)
      if (address.toString.startsWith(prefix)) {
        flag = false
      }
    }
    (address, key)
  }
}
