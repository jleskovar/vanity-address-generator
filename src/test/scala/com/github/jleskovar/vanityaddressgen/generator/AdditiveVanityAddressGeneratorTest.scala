package com.github.jleskovar.vanityaddressgen.generator

import org.bitcoinj.core.NetworkParameters
import org.scalatest.{FunSuite, Matchers}

/**
 * Created by james on 6/05/15.
 */
// @Ignore
class AdditiveVanityAddressGeneratorTest extends FunSuite with Matchers {

  val networkParameters: NetworkParameters = NetworkParameters.fromID(NetworkParameters.ID_MAINNET)

  test("additive vanity address generation actually works") {
    fail
  }

}
