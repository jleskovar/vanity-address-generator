package com.github.jleskovar.vanityaddressgen.generator

import org.bitcoinj.core.{ECKey, Address, NetworkParameters}

/**
 * Created by james on 7/05/15.
 */
class AdditiveVanityAddressGenerator(parameters: NetworkParameters, pubKey: ECKey) extends AddressGenerator {
  override def generateAddress(prefix: String): Option[(Address, ECKey)] = ???
}
