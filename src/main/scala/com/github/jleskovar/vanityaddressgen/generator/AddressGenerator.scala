package com.github.jleskovar.vanityaddressgen.generator

import org.bitcoinj.core.{ECKey, Address}

/**
 * Created by james on 6/05/15.
 */
trait AddressGenerator {

  def findAddressWithPrefix(prefix: String): Option[(Address, ECKey)]

}
